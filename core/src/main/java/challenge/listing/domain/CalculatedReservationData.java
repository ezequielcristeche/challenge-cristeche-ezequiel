package challenge.listing.domain;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Clase encargada de mapear el costo de reserva
 *
 * @author Ezequiel Cristeche
 * @since 8/9/2020
 */
@Getter
public class CalculatedReservationData {

    Long nightsCount;

    BigDecimal nightCost;

    BigDecimal discount;

    BigDecimal cleaningFee;

    BigDecimal total;

    public CalculatedReservationData(Long nightsCount, BigDecimal nightCost,
                                     BigDecimal discount, BigDecimal cleaningFee, BigDecimal total) {
        this.nightsCount = nightsCount;
        this.nightCost = nightCost;
        this.discount = discount;
        this.cleaningFee = cleaningFee;
        this.total = total;
    }
}
