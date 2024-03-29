package at.fhtw.swen3.persistence.entities;


import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@Table(name = "parcels")
public class ParcelEntity {
    public ParcelEntity() {

    }

    public enum StateEnum {
        PICKUP("Pickup"),

        INTRANSPORT("InTransport"),

        INTRUCKDELIVERY("InTruckDelivery"),

        TRANSFERRED("Transferred"),

        DELIVERED("Delivered");

        private String value;

        StateEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ParcelEntity.StateEnum fromValue(String value) {
            for (ParcelEntity.StateEnum b : ParcelEntity.StateEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long id;

    @DecimalMin("0")
    @Column
    private Float weight;

    @OneToOne
    @NotNull
    @JoinColumn(name = "recipient_id",referencedColumnName = "id")
    private RecipientEntity recipient;

    @OneToOne
    @NotNull
    @JoinColumn(name = "sender_id",referencedColumnName = "id")
    private RecipientEntity sender;

    @Pattern(regexp = "^[A-Z0-9]{9}$",message = ValidatorErrorMessages.ERROR_MESSAGE_PARCEL_CODE)
    @NotNull
    @Column
    private String trackingId;

    @NotNull
    @Column
    private StateEnum state;

    @Singular
    @OneToMany
    //@NotNull
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @Singular
    @OneToMany
    //@NotNull
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}
