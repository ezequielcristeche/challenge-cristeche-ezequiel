package challenge.listing.service.get;

import challenge.commons.annotation.Service;
import challenge.commons.exception.DomainInvalidRequestException;
import challenge.commons.exception.DomainNotFoundException;
import challenge.listing.domain.CalculatedReservationData;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.repository.ListingRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.WEEKS;

/**
 * Servidor de dominio que contempla el caso de obtener un listado
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Service
public class GetListing {

    private static Logger logger = LoggerFactory.getLogger(GetListing.class);

    private ListingRepository listingRepository;

    public GetListing(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }


    public Listing getListing(ListingId listingId) {
        Listing listing = listingRepository.findById(listingId);
        if (Objects.isNull(listing)) {
            logger.warn("No existe un listado con id {}", listingId.getId());
            throw new DomainNotFoundException(String.format("No existe un listado con id %s", listingId.getId()));
        }

        return listing;
    }


    public List<Listing> showAllListing() {
        List<Listing> listingList = listingRepository.findAll();
        if (CollectionUtils.isEmpty(listingList)) {
            logger.warn("No hay listados para mostrar");
            throw new DomainNotFoundException("No hay listados para mostrar");
        }

        return listingList;
    }

    public CalculatedReservationData calculateReservationCost(ListingId listingId, LocalDate currentDate,
                                                              LocalDate checkin, LocalDate checkout) {
        Listing listing = this.getListing(listingId);
        verifyDateReservation(currentDate, checkin, checkout);
        //calculo los dias
        long totalDays = DAYS.between(checkin, checkout);
        //calculo el precio por noche
        BigDecimal price = listing.getBasePrice().multiply(new BigDecimal(totalDays));
        //calculo las cantidad de semanas para aplicar el descuento semanal
        long weeks = WEEKS.between(checkin, checkout);
        BigDecimal totalWeeklyDiscount = listing.getWeeklyDiscount().multiply(new BigDecimal(weeks));
        //calculo el descuento mensual. En este caso como el maximo es 28 dias, no se multiplica por la cantidad
        //de meses
        BigDecimal totalMonthlyDiscount = listing.getMonthlyDiscount();
        //sumo descuento mensual y semanal
        BigDecimal totalDiscount = totalWeeklyDiscount.add(totalMonthlyDiscount);

        //calculo subtotal
        BigDecimal subtotal = price.add(listing.getCleaningFee());
        //calcula total, restandole el descuento total
        BigDecimal total = subtotal.subtract(totalDiscount);
        return new CalculatedReservationData(totalDays, price, totalDiscount, listing.getCleaningFee(), total);
    }

    /**
     * verifica que la fecha enviada por el usuario no sea menor a la fecha checkin ni mayor a la fecha checkout
     * verifica que la fecha checkin no sea mayor a la fecha del checkout
     * verifica que no se pueeda reservar un listado por más de 28 dias
     *
     * @param currentDate fecha enviada por el usuario
     * @param checkin     fecha de entrada
     * @param checkout    fecha de salida
     */
    private void verifyDateReservation(LocalDate currentDate, LocalDate checkin, LocalDate checkout) {
        if (currentDate.isBefore(checkin) || currentDate.isAfter(checkout)) {
            logger.warn("La fecha {} no se encuentra dentro de las fechas de reserva", currentDate.toString());
            throw new DomainInvalidRequestException(String.format("La fecha %s no se encuentra dentro de " +
                    "las fechas de reserva", currentDate.toString()));
        } else if (checkin.isAfter(checkout)) {
            logger.warn("La fecha checkin {} es mayor a la fecha checkout {}", checkin.toString(), checkout.toString());
            throw new DomainInvalidRequestException(String.format("La fecha checkin %s es mayor a la fecha " +
                    "checkout %s", checkin.toString(), checkout.toString()));
        } else if (DAYS.between(checkin, checkout) > 28L) {
            logger.warn("No se puede reservar un listado por más de 28 dias");
            throw new DomainInvalidRequestException("No se puede reservar un listado por más de 28 dias");
        }
    }


}
