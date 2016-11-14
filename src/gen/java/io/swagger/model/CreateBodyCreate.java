package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * CreateBodyCreate
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class CreateBodyCreate   {
  private Integer requestedExecutionDate = null;

  private String debtor = null;

  private String creditor = null;

  private String amount = null;

  private String chargeBarrier = null;

  private String serviceLevelCode = null;

  public CreateBodyCreate requestedExecutionDate(Integer requestedExecutionDate) {
    this.requestedExecutionDate = requestedExecutionDate;
    return this;
  }

   /**
   * Get requestedExecutionDate
   * @return requestedExecutionDate
  **/
  @ApiModelProperty(value = "")
  public Integer getRequestedExecutionDate() {
    return requestedExecutionDate;
  }

  public void setRequestedExecutionDate(Integer requestedExecutionDate) {
    this.requestedExecutionDate = requestedExecutionDate;
  }

  public CreateBodyCreate debtor(String debtor) {
    this.debtor = debtor;
    return this;
  }

   /**
   * Get debtor
   * @return debtor
  **/
  @ApiModelProperty(value = "")
  public String getDebtor() {
    return debtor;
  }

  public void setDebtor(String debtor) {
    this.debtor = debtor;
  }

  public CreateBodyCreate creditor(String creditor) {
    this.creditor = creditor;
    return this;
  }

   /**
   * Get creditor
   * @return creditor
  **/
  @ApiModelProperty(value = "")
  public String getCreditor() {
    return creditor;
  }

  public void setCreditor(String creditor) {
    this.creditor = creditor;
  }

  public CreateBodyCreate amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public CreateBodyCreate chargeBarrier(String chargeBarrier) {
    this.chargeBarrier = chargeBarrier;
    return this;
  }

   /**
   * Get chargeBarrier
   * @return chargeBarrier
  **/
  @ApiModelProperty(value = "")
  public String getChargeBarrier() {
    return chargeBarrier;
  }

  public void setChargeBarrier(String chargeBarrier) {
    this.chargeBarrier = chargeBarrier;
  }

  public CreateBodyCreate serviceLevelCode(String serviceLevelCode) {
    this.serviceLevelCode = serviceLevelCode;
    return this;
  }

   /**
   * Get serviceLevelCode
   * @return serviceLevelCode
  **/
  @ApiModelProperty(value = "")
  public String getServiceLevelCode() {
    return serviceLevelCode;
  }

  public void setServiceLevelCode(String serviceLevelCode) {
    this.serviceLevelCode = serviceLevelCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBodyCreate createBodyCreate = (CreateBodyCreate) o;
    return Objects.equals(this.requestedExecutionDate, createBodyCreate.requestedExecutionDate) &&
        Objects.equals(this.debtor, createBodyCreate.debtor) &&
        Objects.equals(this.creditor, createBodyCreate.creditor) &&
        Objects.equals(this.amount, createBodyCreate.amount) &&
        Objects.equals(this.chargeBarrier, createBodyCreate.chargeBarrier) &&
        Objects.equals(this.serviceLevelCode, createBodyCreate.serviceLevelCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestedExecutionDate, debtor, creditor, amount, chargeBarrier, serviceLevelCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBodyCreate {\n");
    
    sb.append("    requestedExecutionDate: ").append(toIndentedString(requestedExecutionDate)).append("\n");
    sb.append("    debtor: ").append(toIndentedString(debtor)).append("\n");
    sb.append("    creditor: ").append(toIndentedString(creditor)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    chargeBarrier: ").append(toIndentedString(chargeBarrier)).append("\n");
    sb.append("    serviceLevelCode: ").append(toIndentedString(serviceLevelCode)).append("\n");
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

