package challenge.listing.domain;

import challenge.commons.util.ValidatorUtils;
import challenge.user.domain.UserId;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * Domain que representativo de la tabla Listing
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Getter
public class Listing {

    private ListingId listingId;

    private UserId ownerId;

    private String name;

    private String slug;

    private String description;

    private Integer adults;

    private Integer children;

    private Boolean isPetsAllowed;

    private BigDecimal basePrice;

    private BigDecimal cleaningFee;

    private String imageUrl;

    private BigDecimal weeklyDiscount;

    private BigDecimal monthlyDiscount;

    public Listing(UserId ownerId, String name, String slug, String description, Integer adults,
                   Integer children, Boolean isPetsAllowed, BigDecimal basePrice, BigDecimal cleaningFee,
                   String imageUrl, BigDecimal weeklyDiscount, BigDecimal monthlyDiscount) {
        this.ownerId = ownerId;
        ValidatorUtils.validateAttribute(name, "el nombre no puede estar vacio", 60,
                "el nombre supera el máximo permitido (60)");
        this.name = name;
        ValidatorUtils.validateAttribute(slug, "el slug no puede estar vacio", 60,
                "el slug supera el máximo permitido (60)");
        this.slug = slug;
        ValidatorUtils.validateAttribute(description, "la descripcion no puede estar vacia",
                60, "la descripcion supera el máximo permitido (60)");
        this.description = description;
        ValidatorUtils.validateNull(adults, "El numero de adultos no puede ser vacio");
        this.adults = adults;
        ValidatorUtils.validateNull(children, "El numero de chicos no puede ser vacio");
        this.children = children;
        ValidatorUtils.validateNull(isPetsAllowed, "indicar si se permite o no mascotas");
        this.isPetsAllowed = isPetsAllowed;
        ValidatorUtils.validateNull(basePrice, "Indicar un precio base");
        this.basePrice = basePrice;
        ValidatorUtils.validateNull(cleaningFee, "Indicar la tasa de limpieza");
        this.cleaningFee = cleaningFee;
        ValidatorUtils.validateNull(imageUrl, "indicar la ruta de la imagen");
        this.imageUrl = imageUrl;
        ValidatorUtils.validateNull(weeklyDiscount, "indicar el descuento semanal");
        this.weeklyDiscount = weeklyDiscount;
        ValidatorUtils.validateNull(monthlyDiscount, "indicar el descuento mensual");
        this.monthlyDiscount = monthlyDiscount;
    }

    public Listing(ListingId listingId, UserId ownerId, String name, String slug, String description, Integer adults,
                   Integer children, Boolean isPetsAllowed, BigDecimal basePrice, BigDecimal cleaningFee,
                   String imageUrl, BigDecimal weeklyDiscount, BigDecimal monthlyDiscount) {
        this.listingId = listingId;
        this.ownerId = ownerId;
        ValidatorUtils.validateAttribute(name, "el nombre no puede estar vacio", 60,
                "el nombre supera el máximo permitido (60)");
        this.name = name;
        ValidatorUtils.validateAttribute(slug, "el slug no puede estar vacio", 60,
                "el slug supera el máximo permitido (60)");
        this.slug = slug;
        ValidatorUtils.validateAttribute(description, "la descripcion no puede estar vacia",
                60, "la descripcion supera el máximo permitido (60)");
        this.description = description;
        ValidatorUtils.validateNull(adults, "El numero de adultos no puede ser vacio");
        this.adults = adults;
        ValidatorUtils.validateNull(children, "El numero de chicos no puede ser vacio");
        this.children = children;
        ValidatorUtils.validateNull(isPetsAllowed, "indicar si se permite o no mascotas");
        this.isPetsAllowed = isPetsAllowed;
        ValidatorUtils.validateNull(basePrice, "Indicar un precio base");
        this.basePrice = basePrice;
        ValidatorUtils.validateNull(cleaningFee, "Indicar la tasa de limpieza");
        this.cleaningFee = cleaningFee;
        ValidatorUtils.validateNull(imageUrl, "indicar la ruta de la imagen");
        this.imageUrl = imageUrl;
        ValidatorUtils.validateNull(weeklyDiscount, "indicar el descuento semanal");
        this.weeklyDiscount = weeklyDiscount;
        ValidatorUtils.validateNull(monthlyDiscount, "indicar el descuento mensual");
        this.monthlyDiscount = monthlyDiscount;
    }

    public static Listing crear(UserId ownerId, String name, String slug, String description,
                                Integer adults, Integer children, Boolean isPetsAllowed, BigDecimal basePrice,
                                BigDecimal cleaningFee, String imageUrl, BigDecimal weeklyDiscount,
                                BigDecimal monthlyDiscount) {
        return new Listing(ownerId, name, slug, description, adults,
                children, isPetsAllowed, basePrice, cleaningFee,
                imageUrl, weeklyDiscount, monthlyDiscount);
    }

    public static Listing actualizar(ListingId listingId, UserId ownerId, String name, String slug, String description,
                                     Integer adults, Integer children, Boolean isPetsAllowed, BigDecimal basePrice,
                                     BigDecimal cleaningFee, String imageUrl, BigDecimal weeklyDiscount,
                                     BigDecimal monthlyDiscount) {
        return new Listing(listingId, ownerId, name, slug, description, adults,
                children, isPetsAllowed, basePrice, cleaningFee,
                imageUrl, weeklyDiscount, monthlyDiscount);
    }
}
