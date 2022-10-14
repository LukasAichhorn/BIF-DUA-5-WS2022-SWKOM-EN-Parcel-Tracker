package at.fhtw.swen3.persistence;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TruckAllOf
 */

@JsonTypeName("truck_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-14T15:32:51.812001Z[Etc/UTC]")
public class TruckAllOf {

  @JsonProperty("regionGeoJson")
  private String regionGeoJson;

  @JsonProperty("numberPlate")
  private String numberPlate;

  public TruckAllOf regionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
    return this;
  }

  /**
   * GeoJSON (https://geojson.org/) of the area covered by the truck.
   * @return regionGeoJson
  */
  
  @Schema(name = "regionGeoJson", description = "GeoJSON (https://geojson.org/) of the area covered by the truck.", required = false)
  public String getRegionGeoJson() {
    return regionGeoJson;
  }

  public void setRegionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
  }

  public TruckAllOf numberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
    return this;
  }

  /**
   * The truck's number plate.
   * @return numberPlate
  */
  
  @Schema(name = "numberPlate", description = "The truck's number plate.", required = false)
  public String getNumberPlate() {
    return numberPlate;
  }

  public void setNumberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TruckAllOf truckAllOf = (TruckAllOf) o;
    return Objects.equals(this.regionGeoJson, truckAllOf.regionGeoJson) &&
        Objects.equals(this.numberPlate, truckAllOf.numberPlate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionGeoJson, numberPlate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TruckAllOf {\n");
    sb.append("    regionGeoJson: ").append(toIndentedString(regionGeoJson)).append("\n");
    sb.append("    numberPlate: ").append(toIndentedString(numberPlate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

