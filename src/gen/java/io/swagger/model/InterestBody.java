package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.InterestBodyInterest;



/**
 * Data object encapsulating the transition parameters for the interest transition
 **/

/**
 * Data object encapsulating the transition parameters for the interest transition
 */
@ApiModel(description = "Data object encapsulating the transition parameters for the interest transition")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class InterestBody   {
  private InterestBodyInterest interest = null;

  public InterestBody interest(InterestBodyInterest interest) {
    this.interest = interest;
    return this;
  }

   /**
   * Get interest
   * @return interest
  **/
  @ApiModelProperty(value = "")
  public InterestBodyInterest getInterest() {
    return interest;
  }

  public void setInterest(InterestBodyInterest interest) {
    this.interest = interest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InterestBody interestBody = (InterestBody) o;
    return Objects.equals(this.interest, interestBody.interest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InterestBody {\n");
    
    sb.append("    interest: ").append(toIndentedString(interest)).append("\n");
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

