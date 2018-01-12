package com.shipinfo.admin.modules.admin.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhenTomcat
 * @since 2018-01-05
 */
@TableName("t_public_ship")
public class PublicShip extends Model<PublicShip> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * IMO
     */
	private String imo;
    /**
     * Status
     */
	private String status;
    /**
     * Name:船舶名称
     */
	private String name;
    /**
     * Built Year 建造年份
     */
	@TableField("build_year")
	private String buildYear;
    /**
     * 建造者：builder
     */
	private String builder;
    /**
     * 该条船的本身类型：ship_type
     */
	@TableField("ship_type")
	private String shipType;
    /**
     * ICE
     */
	private String ice;
    /**
     * Owned/Managed
     */
	@TableField("own_manage")
	private String ownManage;
    /**
     * Bunkers
     */
	private String bunker;
    /**
     * Bulker :Hatch Type, Gas:Tank No., Chemical:Total Cu.m, Tanker:Total Cu.m, Container:Gear, Multi-Purpose:De./Ho./Ha, Ro-Ro/PCC:Lane L/W/H
     */
	private String twopenult;
    /**
     * Bulker:Grain/Bale, Gas:Pumps, Chemical:Tnk/Pmp/Sep, Tanker:Tnk/Pmp/Sep, Container:DWT/TEU, Multi-Purpose:Teu, Ro-Ro/PCC:Veh.
     */
	private String threepenult;
    /**
     * TPC
     */
	private String tpc;
    /**
     * Call Sign
     */
	private String callsign;
    /**
     * HP
     */
	private String hp;
    /**
     * Bulker:Gear, Gas:Max P/Min T, Chemical:Max t/hr, Tanker:Max t/hr, Container:Thrust, Multi-Purpose:Gear, Ro-Ro/PCC:M.Ramp
     */
	private String fourpenult;
    /**
     * NT
     */
	private String nt;
    /**
     * Bulker:Lakes Fitted, Gas:Cargo, Chemical:Coating, Tanker:Coating, Container:TEU
     */
	private String onelast;
    /**
     * Bulker:Log Fitted, Gas:Ammonia, Chemical:IMO grade, Tanker:IMO grade, Container:Rfr Teu/Plugs
     */
	private String twolast;
    /**
     * Bulker:Str.Ore, Gas:Gas Con, Chemical:Heating, Tanker:Heating, Container:Ho/De
     */
	private String threelast;
    /**
     * Bulker:Str.Heavy, Gas:Liq.Con, Chemical:SBT, Tanker:SBT, Container:Tiers
     */
	private String fourlast;
    /**
     * Bulker:Ho/Ha, Gas:Tank Type, Chemical:Hull Type, Tanker:Hull Type, Container:Ho/Ha, Multi-Purpose:
     */
	private String onepenult;
    /**
     * LOA
     */
	private String loa;
    /**
     * Beam
     */
	private String beam;
    /**
     * GT
     */
	private String ggt;
    /**
     * DWT
     */
	private String dwt;
    /**
     * Flag
     */
	private String flag;
    /**
     * 船级社:ship_class
     */
	@TableField("ship_class")
	private String shipClass;
    /**
     * 船舶的过去名称：ex.Name
     */
	private String exname;
    /**
     * SS
     */
	private String ss;
    /**
     * DD
     */
	private String dd;
    /**
     * Speed
     */
	private String speed;
    /**
     * Draft
     */
	private String draft;
    /**
     * Ldt
     */
	private String ldt;
    /**
     * M/E  Make/Type
     */
	@TableField("me_maker_type")
	private String meMakerType;
	@TableField("me_maker")
	private String meMaker;
	@TableField("me_mype")
	private String meMype;
    /**
     * M/E BHP/RPM
     */
	@TableField("me_bhp_rpm")
	private String meBhpRpm;
    /**
     * M/E Cyl.bore
     */
	@TableField("me_cyl_bore")
	private String meCylBore;
    /**
     * AUX.E Maker
     */
	@TableField("aux_make")
	private String auxMake;
    /**
     * AUX.E Type
     */
	@TableField("aux_type")
	private String auxType;
    /**
     * AUX.E Qty
     */
	@TableField("aux_qty")
	private String auxQty;
    /**
     * AUX.E Rated output/revolution(KW/rpm)
     */
	@TableField("aux_rate_output")
	private String auxRateOutput;
    /**
     * AUX.E Cyl.bore
     */
	@TableField("aux_cyl_bore")
	private String auxCylBore;
    /**
     * Crane Type
     */
	@TableField("crane_type")
	private String craneType;
    /**
     * Crane Qty
     */
	@TableField("crane_qty")
	private String craneQty;
    /**
     * Boiler AUX.boiler heating area(m2)
     */
	@TableField("boiler_heating_area")
	private String boilerHeatingArea;
    /**
     * Boiler Large water tube boiler evaporation(ton/hour)
     */
	@TableField("boiler_water_evaporation")
	private String boilerWaterEvaporation;
    /**
     * Boiler Gas boiler heating area(m2)
     */
	@TableField("boiler_gas_heating_area")
	private String boilerGasHeatingArea;
    /**
     * Boiler Exhaust boiler heating area(m2)
     */
	@TableField("boiler_exhaust_heating_area")
	private String boilerExhaustHeatingArea;
    /**
     * EM'CY GEN Maker
     */
	@TableField("ecg_maker")
	private String ecgMaker;
    /**
     * EM'CY GEN Type
     */
	@TableField("ecg_type")
	private String ecgType;
    /**
     * Windlass Anchor
     */
	@TableField("windlass_anchor")
	private String windlassAnchor;
    /**
     * Windlass Capstan mooring(mm)
     */
	@TableField("windlass_capstan_mooring")
	private String windlassCapstanMooring;
    /**
     * Tailshaft Dia.(mm)
     */
	private String tasishaft;
    /**
     * Anchor(kg)
     */
	private String anchor;
    /**
     * Anchor chain dia.(mm)
     */
	@TableField("anchor_chain_dia")
	private String anchorChainDia;
    /**
     * Air compressor low pressure cly.bore(mm)
     */
	@TableField("air_compressor_low")
	private String airCompressorLow;
    /**
     * Freon refrigetating compressor rated ourput(m3)
     */
	@TableField("freon_refrigerate")
	private String freonRefrigerate;
    /**
     * Refrigetating system heat exchange area(m2)
     */
	@TableField("refrigerate_system_heat")
	private String refrigerateSystemHeat;
    /**
     * Tubular  Heat Exhaust surface area(m2)
     */
	@TableField("tubluar_heat_exhaust")
	private String tubluarHeatExhaust;
    /**
     * Propeller
     */
	private String propeller;
    /**
     * 图片名称
     */
	private String filename;
    /**
     * 更新时间
     */
	@TableField("update_date")
	private Date updateDate;
    /**
     * 备注
     */
	private String remark;
    /**
     * 船舶类型id
     */
	@TableField("type_id")
	private Integer typeId;
    /**
     * 船东详情
     */
	@TableField("owners_details")
	private String ownersDetails;
    /**
     * 船舶最新位置
     */
	@TableField("vessel_position")
	private String vesselPosition;
    /**
     * 船东意向售价
     */
	@TableField("sellers_price")
	private String sellersPrice;
    /**
     * 建造国家
     */
	@TableField("built_country")
	private Integer builtCountry;
	private String dynamic;
	@TableField("sea_fo_do")
	private String seaFoDo;
	@TableField("port_fo_do")
	private String portFoDo;
	@TableField("anchorage_fo_do")
	private String anchorageFoDo;
	@TableField("create_by")
	private String createBy;
	@TableField("create_date")
	private Date createDate;
	@TableField("update_by")
	private String updateBy;
	@TableField("del_flag")
	private Integer delFlag;

	@TableField(exist=false)
	private PublicShipType type;

	@TableField(exist=false)
	private List<Media> medias;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImo() {
		return imo;
	}

	public void setImo(String imo) {
		this.imo = imo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public String getOwnManage() {
		return ownManage;
	}

	public void setOwnManage(String ownManage) {
		this.ownManage = ownManage;
	}

	public String getBunker() {
		return bunker;
	}

	public void setBunker(String bunker) {
		this.bunker = bunker;
	}

	public String getTwopenult() {
		return twopenult;
	}

	public void setTwopenult(String twopenult) {
		this.twopenult = twopenult;
	}

	public String getThreepenult() {
		return threepenult;
	}

	public void setThreepenult(String threepenult) {
		this.threepenult = threepenult;
	}

	public String getTpc() {
		return tpc;
	}

	public void setTpc(String tpc) {
		this.tpc = tpc;
	}

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getFourpenult() {
		return fourpenult;
	}

	public void setFourpenult(String fourpenult) {
		this.fourpenult = fourpenult;
	}

	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getOnelast() {
		return onelast;
	}

	public void setOnelast(String onelast) {
		this.onelast = onelast;
	}

	public String getTwolast() {
		return twolast;
	}

	public void setTwolast(String twolast) {
		this.twolast = twolast;
	}

	public String getThreelast() {
		return threelast;
	}

	public void setThreelast(String threelast) {
		this.threelast = threelast;
	}

	public String getFourlast() {
		return fourlast;
	}

	public void setFourlast(String fourlast) {
		this.fourlast = fourlast;
	}

	public String getOnepenult() {
		return onepenult;
	}

	public void setOnepenult(String onepenult) {
		this.onepenult = onepenult;
	}

	public String getLoa() {
		return loa;
	}

	public void setLoa(String loa) {
		this.loa = loa;
	}

	public String getBeam() {
		return beam;
	}

	public void setBeam(String beam) {
		this.beam = beam;
	}

	public String getGgt() {
		return ggt;
	}

	public void setGgt(String ggt) {
		this.ggt = ggt;
	}

	public String getDwt() {
		return dwt;
	}

	public void setDwt(String dwt) {
		this.dwt = dwt;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getShipClass() {
		return shipClass;
	}

	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}

	public String getExname() {
		return exname;
	}

	public void setExname(String exname) {
		this.exname = exname;
	}

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	public String getLdt() {
		return ldt;
	}

	public void setLdt(String ldt) {
		this.ldt = ldt;
	}

	public String getMeMakerType() {
		return meMakerType;
	}

	public void setMeMakerType(String meMakerType) {
		this.meMakerType = meMakerType;
	}

	public String getMeMaker() {
		return meMaker;
	}

	public void setMeMaker(String meMaker) {
		this.meMaker = meMaker;
	}

	public String getMeMype() {
		return meMype;
	}

	public void setMeMype(String meMype) {
		this.meMype = meMype;
	}

	public String getMeBhpRpm() {
		return meBhpRpm;
	}

	public void setMeBhpRpm(String meBhpRpm) {
		this.meBhpRpm = meBhpRpm;
	}

	public String getMeCylBore() {
		return meCylBore;
	}

	public void setMeCylBore(String meCylBore) {
		this.meCylBore = meCylBore;
	}

	public String getAuxMake() {
		return auxMake;
	}

	public void setAuxMake(String auxMake) {
		this.auxMake = auxMake;
	}

	public String getAuxType() {
		return auxType;
	}

	public void setAuxType(String auxType) {
		this.auxType = auxType;
	}

	public String getAuxQty() {
		return auxQty;
	}

	public void setAuxQty(String auxQty) {
		this.auxQty = auxQty;
	}

	public String getAuxRateOutput() {
		return auxRateOutput;
	}

	public void setAuxRateOutput(String auxRateOutput) {
		this.auxRateOutput = auxRateOutput;
	}

	public String getAuxCylBore() {
		return auxCylBore;
	}

	public void setAuxCylBore(String auxCylBore) {
		this.auxCylBore = auxCylBore;
	}

	public String getCraneType() {
		return craneType;
	}

	public void setCraneType(String craneType) {
		this.craneType = craneType;
	}

	public String getCraneQty() {
		return craneQty;
	}

	public void setCraneQty(String craneQty) {
		this.craneQty = craneQty;
	}

	public String getBoilerHeatingArea() {
		return boilerHeatingArea;
	}

	public void setBoilerHeatingArea(String boilerHeatingArea) {
		this.boilerHeatingArea = boilerHeatingArea;
	}

	public String getBoilerWaterEvaporation() {
		return boilerWaterEvaporation;
	}

	public void setBoilerWaterEvaporation(String boilerWaterEvaporation) {
		this.boilerWaterEvaporation = boilerWaterEvaporation;
	}

	public String getBoilerGasHeatingArea() {
		return boilerGasHeatingArea;
	}

	public void setBoilerGasHeatingArea(String boilerGasHeatingArea) {
		this.boilerGasHeatingArea = boilerGasHeatingArea;
	}

	public String getBoilerExhaustHeatingArea() {
		return boilerExhaustHeatingArea;
	}

	public void setBoilerExhaustHeatingArea(String boilerExhaustHeatingArea) {
		this.boilerExhaustHeatingArea = boilerExhaustHeatingArea;
	}

	public String getEcgMaker() {
		return ecgMaker;
	}

	public void setEcgMaker(String ecgMaker) {
		this.ecgMaker = ecgMaker;
	}

	public String getEcgType() {
		return ecgType;
	}

	public void setEcgType(String ecgType) {
		this.ecgType = ecgType;
	}

	public String getWindlassAnchor() {
		return windlassAnchor;
	}

	public void setWindlassAnchor(String windlassAnchor) {
		this.windlassAnchor = windlassAnchor;
	}

	public String getWindlassCapstanMooring() {
		return windlassCapstanMooring;
	}

	public void setWindlassCapstanMooring(String windlassCapstanMooring) {
		this.windlassCapstanMooring = windlassCapstanMooring;
	}

	public String getTasishaft() {
		return tasishaft;
	}

	public void setTasishaft(String tasishaft) {
		this.tasishaft = tasishaft;
	}

	public String getAnchor() {
		return anchor;
	}

	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}

	public String getAnchorChainDia() {
		return anchorChainDia;
	}

	public void setAnchorChainDia(String anchorChainDia) {
		this.anchorChainDia = anchorChainDia;
	}

	public String getAirCompressorLow() {
		return airCompressorLow;
	}

	public void setAirCompressorLow(String airCompressorLow) {
		this.airCompressorLow = airCompressorLow;
	}

	public String getFreonRefrigerate() {
		return freonRefrigerate;
	}

	public void setFreonRefrigerate(String freonRefrigerate) {
		this.freonRefrigerate = freonRefrigerate;
	}

	public String getRefrigerateSystemHeat() {
		return refrigerateSystemHeat;
	}

	public void setRefrigerateSystemHeat(String refrigerateSystemHeat) {
		this.refrigerateSystemHeat = refrigerateSystemHeat;
	}

	public String getTubluarHeatExhaust() {
		return tubluarHeatExhaust;
	}

	public void setTubluarHeatExhaust(String tubluarHeatExhaust) {
		this.tubluarHeatExhaust = tubluarHeatExhaust;
	}

	public String getPropeller() {
		return propeller;
	}

	public void setPropeller(String propeller) {
		this.propeller = propeller;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getOwnersDetails() {
		return ownersDetails;
	}

	public void setOwnersDetails(String ownersDetails) {
		this.ownersDetails = ownersDetails;
	}

	public String getVesselPosition() {
		return vesselPosition;
	}

	public void setVesselPosition(String vesselPosition) {
		this.vesselPosition = vesselPosition;
	}

	public String getSellersPrice() {
		return sellersPrice;
	}

	public void setSellersPrice(String sellersPrice) {
		this.sellersPrice = sellersPrice;
	}

	public Integer getBuiltCountry() {
		return builtCountry;
	}

	public void setBuiltCountry(Integer builtCountry) {
		this.builtCountry = builtCountry;
	}

	public String getDynamic() {
		return dynamic;
	}

	public void setDynamic(String dynamic) {
		this.dynamic = dynamic;
	}

	public String getSeaFoDo() {
		return seaFoDo;
	}

	public void setSeaFoDo(String seaFoDo) {
		this.seaFoDo = seaFoDo;
	}

	public String getPortFoDo() {
		return portFoDo;
	}

	public void setPortFoDo(String portFoDo) {
		this.portFoDo = portFoDo;
	}

	public String getAnchorageFoDo() {
		return anchorageFoDo;
	}

	public void setAnchorageFoDo(String anchorageFoDo) {
		this.anchorageFoDo = anchorageFoDo;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public PublicShipType getType() {
		return type;
	}

	public void setType(PublicShipType type) {
		this.type = type;
	}

	public List<Media> getMedias() {
		return medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	@Override
	public String toString() {
		return "PublicShip{" +
			", id=" + id +
			", imo=" + imo +
			", status=" + status +
			", name=" + name +
			", buildYear=" + buildYear +
			", builder=" + builder +
			", shipType=" + shipType +
			", ice=" + ice +
			", ownManage=" + ownManage +
			", bunker=" + bunker +
			", twopenult=" + twopenult +
			", threepenult=" + threepenult +
			", tpc=" + tpc +
			", callsign=" + callsign +
			", hp=" + hp +
			", fourpenult=" + fourpenult +
			", nt=" + nt +
			", onelast=" + onelast +
			", twolast=" + twolast +
			", threelast=" + threelast +
			", fourlast=" + fourlast +
			", onepenult=" + onepenult +
			", loa=" + loa +
			", beam=" + beam +
			", ggt=" + ggt +
			", dwt=" + dwt +
			", flag=" + flag +
			", shipClass=" + shipClass +
			", exname=" + exname +
			", ss=" + ss +
			", dd=" + dd +
			", speed=" + speed +
			", draft=" + draft +
			", ldt=" + ldt +
			", meMakerType=" + meMakerType +
			", meMaker=" + meMaker +
			", meMype=" + meMype +
			", meBhpRpm=" + meBhpRpm +
			", meCylBore=" + meCylBore +
			", auxMake=" + auxMake +
			", auxType=" + auxType +
			", auxQty=" + auxQty +
			", auxRateOutput=" + auxRateOutput +
			", auxCylBore=" + auxCylBore +
			", craneType=" + craneType +
			", craneQty=" + craneQty +
			", boilerHeatingArea=" + boilerHeatingArea +
			", boilerWaterEvaporation=" + boilerWaterEvaporation +
			", boilerGasHeatingArea=" + boilerGasHeatingArea +
			", boilerExhaustHeatingArea=" + boilerExhaustHeatingArea +
			", ecgMaker=" + ecgMaker +
			", ecgType=" + ecgType +
			", windlassAnchor=" + windlassAnchor +
			", windlassCapstanMooring=" + windlassCapstanMooring +
			", tasishaft=" + tasishaft +
			", anchor=" + anchor +
			", anchorChainDia=" + anchorChainDia +
			", airCompressorLow=" + airCompressorLow +
			", freonRefrigerate=" + freonRefrigerate +
			", refrigerateSystemHeat=" + refrigerateSystemHeat +
			", tubluarHeatExhaust=" + tubluarHeatExhaust +
			", propeller=" + propeller +
			", filename=" + filename +
			", updateDate=" + updateDate +
			", remark=" + remark +
			", typeId=" + typeId +
			", ownersDetails=" + ownersDetails +
			", vesselPosition=" + vesselPosition +
			", sellersPrice=" + sellersPrice +
			", builtCountry=" + builtCountry +
			", dynamic=" + dynamic +
			", seaFoDo=" + seaFoDo +
			", portFoDo=" + portFoDo +
			", anchorageFoDo=" + anchorageFoDo +
			", createBy=" + createBy +
			", createDate=" + createDate +
			", updateBy=" + updateBy +
			", delFlag=" + delFlag +
			"}";
	}
}
