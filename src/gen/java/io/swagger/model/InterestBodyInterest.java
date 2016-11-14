package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * InterestBodyInterest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class InterestBodyInterest   {
  private String currentInterest = null;

  public InterestBodyInterest currentInterest(String currentInterest) {
    this.currentInterest = currentInterest;
    return this;
  }

   /**
   * Get currentInterest
   * @return currentInterest
  **/
  @ApiModelProperty(value = "")
  public String getCurrentInterest() {
    return currentInterest;
  }

  public void setCurrentInterest(String currentInterest) {
    this.currentInterest = currentInterest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InterestBodyInterest interestBodyInterest = (InterestBodyInterest) o;
    return Objects.equals(this.currentInterest, interestBodyInterest.currentInterest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentInterest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestBodyInterest {\n");
    
    sb.append("    currentInterest: ").append(toIndentedString(currentInterest)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

