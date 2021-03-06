/* #LAST_VIEW_OBJECT */
/* #UPDATED */
package org.test.shop.model.domain.entity.view;

// Generated 30.08.2015 21:00:08 by Hibernate Tools 4.3.1

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import org.test.shop.model.domain.SView;


/**
 * ServTransferRoutePointView generated by hbm2java, updated by voovee
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@JsonIgnoreProperties({
			 
			  "firmid"
			, "firm"
			, "serieskey"
			, "servtransferrouteid" 
})
@Entity
@Table(name="serv_transfer_route_point_view")
public class ServTransferRoutePointView extends SView  {

	private static final long serialVersionUID = 2193885124357479L;

	private Integer id;
	private Integer version;
	private String createdby;
	private Date createon;
	private Integer firm;
	private String lastmodifiedby;
	private Date modifyon;
	private String serieskey;
	private String label;
	private BigDecimal fixedallowance;
	private Boolean free;
	private BigDecimal percentageofallowances;
	private String pointfrom;
	private String pointto;
	private Date starton;
	private Integer sum;
	private Integer popularity;
	private String servtransferroute;
	private Integer servtransferrouteid;

	public ServTransferRoutePointView() {
	}

	public ServTransferRoutePointView(Integer id, Integer version,
			String createdby, Date createon, Integer firm,
			String lastmodifiedby, Date modifyon, String serieskey,
			String label, BigDecimal fixedallowance, Boolean free,
			BigDecimal percentageofallowances, String pointfrom,
			String pointto, Date starton, Integer sum, Integer popularity,
			String servtransferroute, Integer servtransferrouteid) {
		this.id = id;
		this.version = version;
		this.createdby = createdby;
		this.createon = createon;
		this.firm = firm;
		this.lastmodifiedby = lastmodifiedby;
		this.modifyon = modifyon;
		this.serieskey = serieskey;
		this.label = label;
		this.fixedallowance = fixedallowance;
		this.free = free;
		this.percentageofallowances = percentageofallowances;
		this.pointfrom = pointfrom;
		this.pointto = pointto;
		this.starton = starton;
		this.sum = sum;
		this.popularity = popularity;
		this.servtransferroute = servtransferroute;
		this.servtransferrouteid = servtransferrouteid;
	}

	@Id
	@Column(name="id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="version")
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name="createdby")
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name="createon", length = 29)
	public Date getCreateon() {
		return this.createon;
	}

	public void setCreateon(Date createon) {
		this.createon = createon;
	}

	@Column(name="firm")
	public Integer getFirm() {
		return this.firm;
	}

	public void setFirm(Integer firm) {
		this.firm = firm;
	}

	@Column(name="lastmodifiedby")
	public String getLastmodifiedby() {
		return this.lastmodifiedby;
	}

	public void setLastmodifiedby(String lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}

	@Column(name="modifyon", length = 29)
	public Date getModifyon() {
		return this.modifyon;
	}

	public void setModifyon(Date modifyon) {
		this.modifyon = modifyon;
	}

	@Column(name="serieskey")
	public String getSerieskey() {
		return this.serieskey;
	}

	public void setSerieskey(String serieskey) {
		this.serieskey = serieskey;
	}

	@Column(name="label")
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name="fixedallowance", precision = 17, scale = 3)
	public BigDecimal getFixedallowance() {
		return this.fixedallowance;
	}

	public void setFixedallowance(BigDecimal fixedallowance) {
		this.fixedallowance = fixedallowance;
	}

	@Column(name="free")
	public Boolean getFree() {
		return this.free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	@Column(name="percentageofallowances", precision = 17, scale = 3)
	public BigDecimal getPercentageofallowances() {
		return this.percentageofallowances;
	}

	public void setPercentageofallowances(BigDecimal percentageofallowances) {
		this.percentageofallowances = percentageofallowances;
	}

	@Column(name="pointfrom")
	public String getPointfrom() {
		return this.pointfrom;
	}

	public void setPointfrom(String pointfrom) {
		this.pointfrom = pointfrom;
	}

	@Column(name="pointto")
	public String getPointto() {
		return this.pointto;
	}

	public void setPointto(String pointto) {
		this.pointto = pointto;
	}

	@Column(name="starton", length = 29)
	public Date getStarton() {
		return this.starton;
	}

	public void setStarton(Date starton) {
		this.starton = starton;
	}

	@Column(name="sum")
	public Integer getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Column(name="popularity")
	public Integer getPopularity() {
		return this.popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	@Column(name="servtransferroute")
	public String getServtransferroute() {
		return this.servtransferroute;
	}

	public void setServtransferroute(String servtransferroute) {
		this.servtransferroute = servtransferroute;
	}

	@Column(name="servtransferrouteid")
	public Integer getServtransferrouteid() {
		return this.servtransferrouteid;
	}

	public void setServtransferrouteid(Integer servtransferrouteid) {
		this.servtransferrouteid = servtransferrouteid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ServTransferRoutePointView))
			return false;
		ServTransferRoutePointView castOther = (ServTransferRoutePointView) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getVersion() == castOther.getVersion()) || (this
						.getVersion() != null && castOther.getVersion() != null && this
						.getVersion().equals(castOther.getVersion())))
				&& ((this.getCreatedby() == castOther.getCreatedby()) || (this
						.getCreatedby() != null
						&& castOther.getCreatedby() != null && this
						.getCreatedby().equals(castOther.getCreatedby())))
				&& ((this.getCreateon() == castOther.getCreateon()) || (this
						.getCreateon() != null
						&& castOther.getCreateon() != null && this
						.getCreateon().equals(castOther.getCreateon())))
				&& ((this.getFirm() == castOther.getFirm()) || (this.getFirm() != null
						&& castOther.getFirm() != null && this.getFirm()
						.equals(castOther.getFirm())))
				&& ((this.getLastmodifiedby() == castOther.getLastmodifiedby()) || (this
						.getLastmodifiedby() != null
						&& castOther.getLastmodifiedby() != null && this
						.getLastmodifiedby().equals(
								castOther.getLastmodifiedby())))
				&& ((this.getModifyon() == castOther.getModifyon()) || (this
						.getModifyon() != null
						&& castOther.getModifyon() != null && this
						.getModifyon().equals(castOther.getModifyon())))
				&& ((this.getSerieskey() == castOther.getSerieskey()) || (this
						.getSerieskey() != null
						&& castOther.getSerieskey() != null && this
						.getSerieskey().equals(castOther.getSerieskey())))
				&& ((this.getLabel() == castOther.getLabel()) || (this
						.getLabel() != null && castOther.getLabel() != null && this
						.getLabel().equals(castOther.getLabel())))
				&& ((this.getFixedallowance() == castOther.getFixedallowance()) || (this
						.getFixedallowance() != null
						&& castOther.getFixedallowance() != null && this
						.getFixedallowance().equals(
								castOther.getFixedallowance())))
				&& ((this.getFree() == castOther.getFree()) || (this.getFree() != null
						&& castOther.getFree() != null && this.getFree()
						.equals(castOther.getFree())))
				&& ((this.getPercentageofallowances() == castOther
						.getPercentageofallowances()) || (this
						.getPercentageofallowances() != null
						&& castOther.getPercentageofallowances() != null && this
						.getPercentageofallowances().equals(
								castOther.getPercentageofallowances())))
				&& ((this.getPointfrom() == castOther.getPointfrom()) || (this
						.getPointfrom() != null
						&& castOther.getPointfrom() != null && this
						.getPointfrom().equals(castOther.getPointfrom())))
				&& ((this.getPointto() == castOther.getPointto()) || (this
						.getPointto() != null && castOther.getPointto() != null && this
						.getPointto().equals(castOther.getPointto())))
				&& ((this.getStarton() == castOther.getStarton()) || (this
						.getStarton() != null && castOther.getStarton() != null && this
						.getStarton().equals(castOther.getStarton())))
				&& ((this.getSum() == castOther.getSum()) || (this.getSum() != null
						&& castOther.getSum() != null && this.getSum().equals(
						castOther.getSum())))
				&& ((this.getPopularity() == castOther.getPopularity()) || (this
						.getPopularity() != null
						&& castOther.getPopularity() != null && this
						.getPopularity().equals(castOther.getPopularity())))
				&& ((this.getServtransferroute() == castOther
						.getServtransferroute()) || (this
						.getServtransferroute() != null
						&& castOther.getServtransferroute() != null && this
						.getServtransferroute().equals(
								castOther.getServtransferroute())))
				&& ((this.getServtransferrouteid() == castOther
						.getServtransferrouteid()) || (this
						.getServtransferrouteid() != null
						&& castOther.getServtransferrouteid() != null && this
						.getServtransferrouteid().equals(
								castOther.getServtransferrouteid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getVersion() == null ? 0 : this.getVersion().hashCode());
		result = 37 * result
				+ (getCreatedby() == null ? 0 : this.getCreatedby().hashCode());
		result = 37 * result
				+ (getCreateon() == null ? 0 : this.getCreateon().hashCode());
		result = 37 * result
				+ (getFirm() == null ? 0 : this.getFirm().hashCode());
		result = 37
				* result
				+ (getLastmodifiedby() == null ? 0 : this.getLastmodifiedby()
						.hashCode());
		result = 37 * result
				+ (getModifyon() == null ? 0 : this.getModifyon().hashCode());
		result = 37 * result
				+ (getSerieskey() == null ? 0 : this.getSerieskey().hashCode());
		result = 37 * result
				+ (getLabel() == null ? 0 : this.getLabel().hashCode());
		result = 37
				* result
				+ (getFixedallowance() == null ? 0 : this.getFixedallowance()
						.hashCode());
		result = 37 * result
				+ (getFree() == null ? 0 : this.getFree().hashCode());
		result = 37
				* result
				+ (getPercentageofallowances() == null ? 0 : this
						.getPercentageofallowances().hashCode());
		result = 37 * result
				+ (getPointfrom() == null ? 0 : this.getPointfrom().hashCode());
		result = 37 * result
				+ (getPointto() == null ? 0 : this.getPointto().hashCode());
		result = 37 * result
				+ (getStarton() == null ? 0 : this.getStarton().hashCode());
		result = 37 * result
				+ (getSum() == null ? 0 : this.getSum().hashCode());
		result = 37
				* result
				+ (getPopularity() == null ? 0 : this.getPopularity()
						.hashCode());
		result = 37
				* result
				+ (getServtransferroute() == null ? 0 : this
						.getServtransferroute().hashCode());
		result = 37
				* result
				+ (getServtransferrouteid() == null ? 0 : this
						.getServtransferrouteid().hashCode());
		return result;
	}
// #SETTER_AND_GETTER
	
// ------------------ Logic part ------------------
	
	public ServTransferRoutePointView specialInit() {
	
		
		return this;
	}
	public ServTransferRoutePointView init() {
		initList();
		initDicts();
		
		return this;
	}
	
	public ServTransferRoutePointView customInitList(List<String> list) {
		
		return this;
	}
	
	public ServTransferRoutePointView initList() {

		return this;
	}
	
	public ServTransferRoutePointView initDicts() {
		return this;
	}
	
	
}