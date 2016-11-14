package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Data structure representing the fields and current FSM state
 **/

/**
 * Data structure representing the fields and current FSM state
 */
@ApiModel(description = "Data structure representing the fields and current FSM state")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class OnUsCreditTransferNLInfo   {
  private String state = null;

  private String amount = null;

  private Integer createdOn = null;

  private Integer requestedExecutionDate = null;

  private Integer actualExecutionDate = null;

  private String debtor = null;

  private String creditor = null;

  private String bic = null;

  private String cstmrCdtTrfInitnGrpHdrMsgId = null;

  private Integer cstmrCdtTrfInitnGrpHdrCreDtTm = null;

  private Integer cstmrCdtTrfInitnGrpHdrNbOfTxs = null;

  private Integer cstmrCdtTrfInitnGrpHdrCtrlSum = null;

  private String cstmrCdtTrfInitnGrpHdrInitgPtyNm = null;

  private String cstmrCdtTrfInitnPmtInfPmtInfId = null;

  private String cstmrCdtTrfInitnPmtInfPmtMtd = null;

  private String cstmrCdtTrfInitnPmtInfBtchBookg = null;

  private String cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty = null;

  private String cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd = null;

  private String cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd = null;

  private Integer cstmrCdtTrfInitnPmtInfReqdExctnDt = null;

  private String cstmrCdtTrfInitnPmtInfDbtrNm = null;

  private String cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry = null;

  private String cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine = null;

  private String cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN = null;

  private String cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId = null;

  private Integer cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd = null;

  private String cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd = null;

  public OnUsCreditTransferNLInfo state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public OnUsCreditTransferNLInfo amount(String amount) {
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

  public OnUsCreditTransferNLInfo createdOn(Integer createdOn) {
    this.createdOn = createdOn;
    return this;
  }

   /**
   * Get createdOn
   * @return createdOn
  **/
  @ApiModelProperty(value = "")
  public Integer getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Integer createdOn) {
    this.createdOn = createdOn;
  }

  public OnUsCreditTransferNLInfo requestedExecutionDate(Integer requestedExecutionDate) {
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

  public OnUsCreditTransferNLInfo actualExecutionDate(Integer actualExecutionDate) {
    this.actualExecutionDate = actualExecutionDate;
    return this;
  }

   /**
   * Get actualExecutionDate
   * @return actualExecutionDate
  **/
  @ApiModelProperty(value = "")
  public Integer getActualExecutionDate() {
    return actualExecutionDate;
  }

  public void setActualExecutionDate(Integer actualExecutionDate) {
    this.actualExecutionDate = actualExecutionDate;
  }

  public OnUsCreditTransferNLInfo debtor(String debtor) {
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

  public OnUsCreditTransferNLInfo creditor(String creditor) {
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

  public OnUsCreditTransferNLInfo bic(String bic) {
    this.bic = bic;
    return this;
  }

   /**
   * Get bic
   * @return bic
  **/
  @ApiModelProperty(value = "")
  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnGrpHdrMsgId(String cstmrCdtTrfInitnGrpHdrMsgId) {
    this.cstmrCdtTrfInitnGrpHdrMsgId = cstmrCdtTrfInitnGrpHdrMsgId;
    return this;
  }

   /**
   * Unique identifier for the instance of the specification
   * @return cstmrCdtTrfInitnGrpHdrMsgId
  **/
  @ApiModelProperty(value = "Unique identifier for the instance of the specification")
  public String getCstmrCdtTrfInitnGrpHdrMsgId() {
    return cstmrCdtTrfInitnGrpHdrMsgId;
  }

  public void setCstmrCdtTrfInitnGrpHdrMsgId(String cstmrCdtTrfInitnGrpHdrMsgId) {
    this.cstmrCdtTrfInitnGrpHdrMsgId = cstmrCdtTrfInitnGrpHdrMsgId;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnGrpHdrCreDtTm(Integer cstmrCdtTrfInitnGrpHdrCreDtTm) {
    this.cstmrCdtTrfInitnGrpHdrCreDtTm = cstmrCdtTrfInitnGrpHdrCreDtTm;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnGrpHdrCreDtTm
   * @return cstmrCdtTrfInitnGrpHdrCreDtTm
  **/
  @ApiModelProperty(value = "")
  public Integer getCstmrCdtTrfInitnGrpHdrCreDtTm() {
    return cstmrCdtTrfInitnGrpHdrCreDtTm;
  }

  public void setCstmrCdtTrfInitnGrpHdrCreDtTm(Integer cstmrCdtTrfInitnGrpHdrCreDtTm) {
    this.cstmrCdtTrfInitnGrpHdrCreDtTm = cstmrCdtTrfInitnGrpHdrCreDtTm;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnGrpHdrNbOfTxs(Integer cstmrCdtTrfInitnGrpHdrNbOfTxs) {
    this.cstmrCdtTrfInitnGrpHdrNbOfTxs = cstmrCdtTrfInitnGrpHdrNbOfTxs;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnGrpHdrNbOfTxs
   * @return cstmrCdtTrfInitnGrpHdrNbOfTxs
  **/
  @ApiModelProperty(value = "")
  public Integer getCstmrCdtTrfInitnGrpHdrNbOfTxs() {
    return cstmrCdtTrfInitnGrpHdrNbOfTxs;
  }

  public void setCstmrCdtTrfInitnGrpHdrNbOfTxs(Integer cstmrCdtTrfInitnGrpHdrNbOfTxs) {
    this.cstmrCdtTrfInitnGrpHdrNbOfTxs = cstmrCdtTrfInitnGrpHdrNbOfTxs;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnGrpHdrCtrlSum(Integer cstmrCdtTrfInitnGrpHdrCtrlSum) {
    this.cstmrCdtTrfInitnGrpHdrCtrlSum = cstmrCdtTrfInitnGrpHdrCtrlSum;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnGrpHdrCtrlSum
   * @return cstmrCdtTrfInitnGrpHdrCtrlSum
  **/
  @ApiModelProperty(value = "")
  public Integer getCstmrCdtTrfInitnGrpHdrCtrlSum() {
    return cstmrCdtTrfInitnGrpHdrCtrlSum;
  }

  public void setCstmrCdtTrfInitnGrpHdrCtrlSum(Integer cstmrCdtTrfInitnGrpHdrCtrlSum) {
    this.cstmrCdtTrfInitnGrpHdrCtrlSum = cstmrCdtTrfInitnGrpHdrCtrlSum;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnGrpHdrInitgPtyNm(String cstmrCdtTrfInitnGrpHdrInitgPtyNm) {
    this.cstmrCdtTrfInitnGrpHdrInitgPtyNm = cstmrCdtTrfInitnGrpHdrInitgPtyNm;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnGrpHdrInitgPtyNm
   * @return cstmrCdtTrfInitnGrpHdrInitgPtyNm
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnGrpHdrInitgPtyNm() {
    return cstmrCdtTrfInitnGrpHdrInitgPtyNm;
  }

  public void setCstmrCdtTrfInitnGrpHdrInitgPtyNm(String cstmrCdtTrfInitnGrpHdrInitgPtyNm) {
    this.cstmrCdtTrfInitnGrpHdrInitgPtyNm = cstmrCdtTrfInitnGrpHdrInitgPtyNm;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfPmtInfId(String cstmrCdtTrfInitnPmtInfPmtInfId) {
    this.cstmrCdtTrfInitnPmtInfPmtInfId = cstmrCdtTrfInitnPmtInfPmtInfId;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfPmtInfId
   * @return cstmrCdtTrfInitnPmtInfPmtInfId
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfPmtInfId() {
    return cstmrCdtTrfInitnPmtInfPmtInfId;
  }

  public void setCstmrCdtTrfInitnPmtInfPmtInfId(String cstmrCdtTrfInitnPmtInfPmtInfId) {
    this.cstmrCdtTrfInitnPmtInfPmtInfId = cstmrCdtTrfInitnPmtInfPmtInfId;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfPmtMtd(String cstmrCdtTrfInitnPmtInfPmtMtd) {
    this.cstmrCdtTrfInitnPmtInfPmtMtd = cstmrCdtTrfInitnPmtInfPmtMtd;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfPmtMtd
   * @return cstmrCdtTrfInitnPmtInfPmtMtd
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfPmtMtd() {
    return cstmrCdtTrfInitnPmtInfPmtMtd;
  }

  public void setCstmrCdtTrfInitnPmtInfPmtMtd(String cstmrCdtTrfInitnPmtInfPmtMtd) {
    this.cstmrCdtTrfInitnPmtInfPmtMtd = cstmrCdtTrfInitnPmtInfPmtMtd;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfBtchBookg(String cstmrCdtTrfInitnPmtInfBtchBookg) {
    this.cstmrCdtTrfInitnPmtInfBtchBookg = cstmrCdtTrfInitnPmtInfBtchBookg;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfBtchBookg
   * @return cstmrCdtTrfInitnPmtInfBtchBookg
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfBtchBookg() {
    return cstmrCdtTrfInitnPmtInfBtchBookg;
  }

  public void setCstmrCdtTrfInitnPmtInfBtchBookg(String cstmrCdtTrfInitnPmtInfBtchBookg) {
    this.cstmrCdtTrfInitnPmtInfBtchBookg = cstmrCdtTrfInitnPmtInfBtchBookg;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty(String cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty) {
    this.cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty = cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty
   * @return cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty() {
    return cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty;
  }

  public void setCstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty(String cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty) {
    this.cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty = cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd(String cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd) {
    this.cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd = cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd
   * @return cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd() {
    return cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd;
  }

  public void setCstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd(String cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd) {
    this.cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd = cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd(String cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd) {
    this.cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd = cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd
   * @return cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd() {
    return cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd;
  }

  public void setCstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd(String cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd) {
    this.cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd = cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfReqdExctnDt(Integer cstmrCdtTrfInitnPmtInfReqdExctnDt) {
    this.cstmrCdtTrfInitnPmtInfReqdExctnDt = cstmrCdtTrfInitnPmtInfReqdExctnDt;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfReqdExctnDt
   * @return cstmrCdtTrfInitnPmtInfReqdExctnDt
  **/
  @ApiModelProperty(value = "")
  public Integer getCstmrCdtTrfInitnPmtInfReqdExctnDt() {
    return cstmrCdtTrfInitnPmtInfReqdExctnDt;
  }

  public void setCstmrCdtTrfInitnPmtInfReqdExctnDt(Integer cstmrCdtTrfInitnPmtInfReqdExctnDt) {
    this.cstmrCdtTrfInitnPmtInfReqdExctnDt = cstmrCdtTrfInitnPmtInfReqdExctnDt;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfDbtrNm(String cstmrCdtTrfInitnPmtInfDbtrNm) {
    this.cstmrCdtTrfInitnPmtInfDbtrNm = cstmrCdtTrfInitnPmtInfDbtrNm;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfDbtrNm
   * @return cstmrCdtTrfInitnPmtInfDbtrNm
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfDbtrNm() {
    return cstmrCdtTrfInitnPmtInfDbtrNm;
  }

  public void setCstmrCdtTrfInitnPmtInfDbtrNm(String cstmrCdtTrfInitnPmtInfDbtrNm) {
    this.cstmrCdtTrfInitnPmtInfDbtrNm = cstmrCdtTrfInitnPmtInfDbtrNm;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry(String cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry) {
    this.cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry = cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry
   * @return cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry() {
    return cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry;
  }

  public void setCstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry(String cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry) {
    this.cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry = cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine(String cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine) {
    this.cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine = cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine
   * @return cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine() {
    return cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine;
  }

  public void setCstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine(String cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine) {
    this.cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine = cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN(String cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN) {
    this.cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN = cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN
   * @return cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN() {
    return cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN;
  }

  public void setCstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN(String cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN) {
    this.cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN = cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC(String cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC) {
    this.cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC = cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC
   * @return cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC() {
    return cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC;
  }

  public void setCstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC(String cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC) {
    this.cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC = cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId = cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId = cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId = cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId = cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt(Integer cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt = cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt
  **/
  @ApiModelProperty(value = "")
  public Integer getCstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt(Integer cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt = cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr = cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr = cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN = cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd = cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd = cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd;
  }

  public OnUsCreditTransferNLInfo cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd = cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd;
    return this;
  }

   /**
   * Get cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd
   * @return cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd
  **/
  @ApiModelProperty(value = "")
  public String getCstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd() {
    return cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd;
  }

  public void setCstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd(String cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd) {
    this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd = cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnUsCreditTransferNLInfo onUsCreditTransferNLInfo = (OnUsCreditTransferNLInfo) o;
    return Objects.equals(this.state, onUsCreditTransferNLInfo.state) &&
        Objects.equals(this.amount, onUsCreditTransferNLInfo.amount) &&
        Objects.equals(this.createdOn, onUsCreditTransferNLInfo.createdOn) &&
        Objects.equals(this.requestedExecutionDate, onUsCreditTransferNLInfo.requestedExecutionDate) &&
        Objects.equals(this.actualExecutionDate, onUsCreditTransferNLInfo.actualExecutionDate) &&
        Objects.equals(this.debtor, onUsCreditTransferNLInfo.debtor) &&
        Objects.equals(this.creditor, onUsCreditTransferNLInfo.creditor) &&
        Objects.equals(this.bic, onUsCreditTransferNLInfo.bic) &&
        Objects.equals(this.cstmrCdtTrfInitnGrpHdrMsgId, onUsCreditTransferNLInfo.cstmrCdtTrfInitnGrpHdrMsgId) &&
        Objects.equals(this.cstmrCdtTrfInitnGrpHdrCreDtTm, onUsCreditTransferNLInfo.cstmrCdtTrfInitnGrpHdrCreDtTm) &&
        Objects.equals(this.cstmrCdtTrfInitnGrpHdrNbOfTxs, onUsCreditTransferNLInfo.cstmrCdtTrfInitnGrpHdrNbOfTxs) &&
        Objects.equals(this.cstmrCdtTrfInitnGrpHdrCtrlSum, onUsCreditTransferNLInfo.cstmrCdtTrfInitnGrpHdrCtrlSum) &&
        Objects.equals(this.cstmrCdtTrfInitnGrpHdrInitgPtyNm, onUsCreditTransferNLInfo.cstmrCdtTrfInitnGrpHdrInitgPtyNm) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfPmtInfId, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfPmtInfId) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfPmtMtd, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfPmtMtd) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfBtchBookg, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfBtchBookg) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfReqdExctnDt, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfReqdExctnDt) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfDbtrNm, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfDbtrNm) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd) &&
        Objects.equals(this.cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd, onUsCreditTransferNLInfo.cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, amount, createdOn, requestedExecutionDate, actualExecutionDate, debtor, creditor, bic, cstmrCdtTrfInitnGrpHdrMsgId, cstmrCdtTrfInitnGrpHdrCreDtTm, cstmrCdtTrfInitnGrpHdrNbOfTxs, cstmrCdtTrfInitnGrpHdrCtrlSum, cstmrCdtTrfInitnGrpHdrInitgPtyNm, cstmrCdtTrfInitnPmtInfPmtInfId, cstmrCdtTrfInitnPmtInfPmtMtd, cstmrCdtTrfInitnPmtInfBtchBookg, cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty, cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd, cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd, cstmrCdtTrfInitnPmtInfReqdExctnDt, cstmrCdtTrfInitnPmtInfDbtrNm, cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry, cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine, cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN, cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC, cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId, cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId, cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt, cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr, cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC, cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm, cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry, cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine, cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN, cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd, cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnUsCreditTransferNLInfo {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    requestedExecutionDate: ").append(toIndentedString(requestedExecutionDate)).append("\n");
    sb.append("    actualExecutionDate: ").append(toIndentedString(actualExecutionDate)).append("\n");
    sb.append("    debtor: ").append(toIndentedString(debtor)).append("\n");
    sb.append("    creditor: ").append(toIndentedString(creditor)).append("\n");
    sb.append("    bic: ").append(toIndentedString(bic)).append("\n");
    sb.append("    cstmrCdtTrfInitnGrpHdrMsgId: ").append(toIndentedString(cstmrCdtTrfInitnGrpHdrMsgId)).append("\n");
    sb.append("    cstmrCdtTrfInitnGrpHdrCreDtTm: ").append(toIndentedString(cstmrCdtTrfInitnGrpHdrCreDtTm)).append("\n");
    sb.append("    cstmrCdtTrfInitnGrpHdrNbOfTxs: ").append(toIndentedString(cstmrCdtTrfInitnGrpHdrNbOfTxs)).append("\n");
    sb.append("    cstmrCdtTrfInitnGrpHdrCtrlSum: ").append(toIndentedString(cstmrCdtTrfInitnGrpHdrCtrlSum)).append("\n");
    sb.append("    cstmrCdtTrfInitnGrpHdrInitgPtyNm: ").append(toIndentedString(cstmrCdtTrfInitnGrpHdrInitgPtyNm)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfPmtInfId: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfPmtInfId)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfPmtMtd: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfPmtMtd)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfBtchBookg: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfBtchBookg)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfPmtTpInfInstrPrty)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfPmtTpInfSvcLvlCd)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfPmtTpInfCtgyPurpCd)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfReqdExctnDt: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfReqdExctnDt)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfDbtrNm: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfDbtrNm)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfDbtrPstlAdrCtry)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfDbtrPstlAdrAdrLine)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfDbtrAcctIdIBAN)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfDbtrAgtFinInstnIdBIC)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdInstrId)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfPmtIdEndToEndId)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfAmt)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfChrgBr)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAgtFinInstnIdBIC)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrNm)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrCtry)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrPstlAdrAdrLine)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfCdtrAcctIdIBAN)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfPurpCd)).append("\n");
    sb.append("    cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd: ").append(toIndentedString(cstmrCdtTrfInitnPmtInfCdtTrfTxInfRmtInfUstrd)).append("\n");
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

