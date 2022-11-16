package at.fhtw.swen3.persistence.entities;


import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ParcelEntity {
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

    private Float weight;

    private RecipientEntity recipient;

    private RecipientEntity sender;
    @Pattern(regexp = "^[A-Z0-9]{9}$",message = ValidatorErrorMessages.ERROR_MESSAGE_PARCEL_CODE)
    private String trackingId;

    private StateEnum state;

    @Singular
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @Singular
    private List<HopArrivalEntity> futureHops = new ArrayList<>();
}
