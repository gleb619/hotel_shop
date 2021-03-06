/* #UPDATED */
/* #CLEARED */
package org.test.shop.model.domain.entity;

// Generated 30.08.2015 21:00:08 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.BatchSize;
import org.test.shop.model.domain.SRel;

import javax.persistence.PreRemove;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelShopPermission generated by hbm2java, updated by voovee
 */
@JsonIgnoreProperties({
			 
			  "firmid"
			, "firm"
			, "serieskey" 
})
@Entity
@Table(name="rel_shop_permission")
public class RelShopPermission extends SRel  {

	private static final long serialVersionUID = 6711221972277937L;

	@JsonProperty("id") private Integer id;
	@JsonProperty("infopermission") private InfoPermission infoPermission;
	@JsonProperty("shoppermission") private ShopPermission shopPermission;

	public RelShopPermission() {
	}

	public RelShopPermission(int id) {
		this.id = id;
	}

	public RelShopPermission(int id, InfoPermission infoPermission,
			ShopPermission shopPermission) {
		this.id = id;
		this.infoPermission = infoPermission;
		this.shopPermission = shopPermission;
	}

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RELSHOPPERMISSION")
	@SequenceGenerator(name = "SQ_RELSHOPPERMISSION", sequenceName = "SQ_RELSHOPPERMISSION", initialValue = 10, allocationSize = 1)
	@Id
	@Column(name="id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Fetch(FetchMode.JOIN)
	@BatchSize(size = 100)
	@ManyToOne(fetch=FetchType.EAGER, optional = true)
	@JoinColumn(name="info_permission_id")
	public InfoPermission getInfoPermission() {
		return this.infoPermission;
	}

	public void setInfoPermission(InfoPermission infoPermission) {
		this.infoPermission = infoPermission;
	}

	@Fetch(FetchMode.JOIN)
	@BatchSize(size = 100)
	@ManyToOne(fetch=FetchType.EAGER, optional = true)
	@JoinColumn(name="shop_permission_id")
	public ShopPermission getShopPermission() {
		return this.shopPermission;
	}

	public void setShopPermission(ShopPermission shopPermission) {
		this.shopPermission = shopPermission;
	}
// #SETTER_AND_GETTER
	
// ------------------ Logic part ------------------
	
	@PreRemove
	public void preRemove() {
		infoPermission = null;
		shopPermission = null;

	}
	
	public RelShopPermission specialInit() {
	
		
		return this;
	}
	
	public RelShopPermission init() {
		initList();
		initDicts();
		
		return this;
	}
	
	public RelShopPermission preInitList() {

		return this;
	}
	
	public RelShopPermission initList() {

		return this;
	}
	
	public RelShopPermission initDicts() {
		initSentity(getInfoPermission());
		initSentity(getShopPermission());

		return this;
	}
	
	
}