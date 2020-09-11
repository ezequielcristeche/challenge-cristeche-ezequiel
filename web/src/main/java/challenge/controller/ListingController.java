package challenge.controller;

import challenge.dto.*;
import challenge.listing.domain.CalculatedReservationData;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.service.create.CreateListing;
import challenge.listing.service.delete.DeleteListing;
import challenge.listing.service.get.GetListing;
import challenge.listing.service.update.UpdateListing;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;
import challenge.specialprice.service.create.CreateSpecialPrice;
import challenge.specialprice.service.delete.DeleteSpecialPrice;
import challenge.user.domain.UserId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contiene los endpoints de {@link Listing}
 *
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */

@RestController
@Api(tags = "Listings")
public class ListingController {

    @Autowired
    private CreateListing createListing;

    @Autowired
    private GetListing getListing;

    @Autowired
    private UpdateListing updateListing;

    @Autowired
    private DeleteListing deleteListing;

    @Autowired
    private CreateSpecialPrice createSpecialPrice;

    @Autowired
    private DeleteSpecialPrice deleteSpecialPrice;


    @PostMapping("/api/listings")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Listado creado exitosamente")
    })
    @ApiOperation(value = "crea una listado nueva", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListingResponseDTO> createListing(@Valid @RequestBody ListingDTO listingDTO) {
        Listing listing = createListing.createListing(new UserId(listingDTO.getOwnerId()), listingDTO.getName(),
                listingDTO.getName(), listingDTO.getDescription(), listingDTO.getAdults(), listingDTO.getChildren(),
                listingDTO.getIsPetsAllowed(), listingDTO.getBasePrice(), listingDTO.getCleaningFee(), listingDTO.getImageUrl(),
                listingDTO.getWeeklyDiscount(), listingDTO.getMonthlyDiscount());
        ListingResponseDTO listingResponseDTO = new ListingResponseDTO(listing.getListingId().getId(),
                listing.getOwnerId().getId(), listing.getName(), listing.getSlug(), listing.getDescription(),
                listing.getAdults(), listing.getChildren(), listing.getIsPetsAllowed(), listing.getBasePrice(),
                listing.getCleaningFee(), listing.getImageUrl(), listing.getWeeklyDiscount(), listing.getMonthlyDiscount(),
               null);
        return new ResponseEntity<>(listingResponseDTO, HttpStatus.CREATED);
    }


    @GetMapping("/api/listings")
    @ApiOperation(value = "Devuelve todos los listados", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ListingResponseDTO> showAllListings() {
        List<Listing> listingList = getListing.showAllListing();
        return listingList.stream().map(listing -> new ListingResponseDTO(listing.getListingId().getId(),
                listing.getOwnerId().getId(), listing.getName(), listing.getSlug(), listing.getDescription(),
                listing.getAdults(), listing.getChildren(), listing.getIsPetsAllowed(), listing.getBasePrice(),
                listing.getCleaningFee(), listing.getImageUrl(), listing.getWeeklyDiscount(),
                listing.getMonthlyDiscount(), listing.getSpecialPriceList().stream().map(specialPrice -> new SpecialPriceResponseDTO(
                specialPrice.getSpecialPriceId().getId(), specialPrice.getDate(), specialPrice.getPrice())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/listings/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado encontrado exitosamente")
    })
    @ApiOperation(value = "Busca un listado por su id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListingResponseDTO> getListing(@PathVariable("uuid") String uuid) {
        Listing listing = getListing.getListing(new ListingId(uuid));
        ListingResponseDTO listingResponseDTO = new ListingResponseDTO(listing.getListingId().getId(),
                listing.getOwnerId().getId(), listing.getName(), listing.getSlug(), listing.getDescription(),
                listing.getAdults(), listing.getChildren(), listing.getIsPetsAllowed(), listing.getBasePrice(),
                listing.getCleaningFee(), listing.getImageUrl(), listing.getWeeklyDiscount(), listing.getMonthlyDiscount(),
                listing.getSpecialPriceList().stream().map(specialPrice -> new SpecialPriceResponseDTO(
                        specialPrice.getSpecialPriceId().getId(), specialPrice.getDate(), specialPrice.getPrice())).collect(Collectors.toList()));
        return new ResponseEntity<>(listingResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/api/listings/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado actualizado exitosamente")
    })
    @ApiOperation(value = "Actualiza un listado", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListingResponseDTO> updateListing(@PathVariable("uuid") String uuid,
                                                            @Valid @RequestBody ListingDTO listingDTO) {
        Listing listing = updateListing.updateListing(new ListingId(uuid), listingDTO.getName(),
                listingDTO.getDescription(), listingDTO.getAdults(), listingDTO.getChildren(),
                listingDTO.getIsPetsAllowed(), listingDTO.getBasePrice(), listingDTO.getCleaningFee(), listingDTO.getImageUrl(),
                listingDTO.getWeeklyDiscount(), listingDTO.getMonthlyDiscount());
        ListingResponseDTO listingResponseDTO = new ListingResponseDTO(listing.getListingId().getId(),
                listing.getOwnerId().getId(), listing.getName(), listing.getSlug(), listing.getDescription(),
                listing.getAdults(), listing.getChildren(), listing.getIsPetsAllowed(), listing.getBasePrice(),
                listing.getCleaningFee(), listing.getImageUrl(), listing.getWeeklyDiscount(), listing.getMonthlyDiscount(),
                null);
        return new ResponseEntity<>(listingResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/api/listings/{uuid}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listado borrado exitosamente")
    })
    @ApiOperation(value = "Elimina un listado")
    public ResponseEntity<String> updateListing(@PathVariable("uuid") String uuid) {
        String idListing = deleteListing.deleteListingById(new ListingId(uuid));
        return new ResponseEntity<>(idListing, HttpStatus.OK);
    }

    @PostMapping("/api/listings/{uuid}/special-prices")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Precios especiales agregados correctamente")
    })
    @ApiOperation(value = "Agrega un precio especial a un listado", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpecialPriceResponseDTO> createSpecialPrice(@PathVariable("uuid") String uuid,
                                                                      @Valid @RequestBody SpecialPriceDTO specialPriceDTO) {
        SpecialPrice specialPrice = createSpecialPrice.createSpecialPrice(new ListingId(uuid), specialPriceDTO.getDate(),
                specialPriceDTO.getPrice());
        SpecialPriceResponseDTO specialPriceResponseDTO = new SpecialPriceResponseDTO(specialPrice.getSpecialPriceId().getId(),
                specialPrice.getDate(), specialPrice.getPrice());
        return new ResponseEntity<>(specialPriceResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/api/listings/{uuid}/special-prices/{idSpecialPrice}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Precio especial eliminado correctamente")
    })
    @ApiOperation(value = "Precio especial eliminado correctamente")
    public ResponseEntity<String> deleteSpecialPrice(@PathVariable("uuid") String uuid,
                                                     @PathVariable("idSpecialPrice") String idSpecialPrice) {
        String specialPrice = deleteSpecialPrice.deleteSpecialPriceById(new ListingId(uuid),
                new SpecialPriceId(idSpecialPrice));
        return new ResponseEntity<>(specialPrice, HttpStatus.OK);
    }

    @GetMapping("/api/listings/{uuid}/checkout")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reserva calculada correctamente")
    })
    @ApiOperation(value = "Calcula el costo de una reserva a partir del checkin y checkout",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CalculatedReservationResponseDTO> calculateReservation(@PathVariable("uuid") String uuid,
                                                                                 @RequestParam
                                                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                         LocalDate dateSelected,
                                                                                 @RequestParam
                                                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                         LocalDate checkin,
                                                                                 @RequestParam
                                                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                         LocalDate checkout) {
        CalculatedReservationData calculatedReservationData = getListing.calculateReservationCost(new ListingId(uuid),
                dateSelected, checkin, checkout);
        CalculatedReservationResponseDTO calculatedReservationResponseDTO =
                new CalculatedReservationResponseDTO(calculatedReservationData.getNightsCount(),
                        calculatedReservationData.getNightCost(), calculatedReservationData.getDiscount(),
                        calculatedReservationData.getCleaningFee(), calculatedReservationData.getTotal());
        return new ResponseEntity<>(calculatedReservationResponseDTO, HttpStatus.OK);
    }

}
