/* #UPDATED */
/* #CLEARED */
package org.test.shop.model.domain.entity;

// Generated 30.08.2015 21:00:08 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.PreRemove;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.hibernate.annotations.SelectBeforeUpdate;

import org.test.shop.model.domain.SEntity;
import java.math.BigDecimal;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * PaymentPrice generated by hbm2java, updated by voovee
 */
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate(false)
@OptimisticLocking(type = OptimisticLockType.VERSION)
@JsonIdentityInfo(generator = JSOGGenerator.class)
@JsonIgnoreProperties({
			 
			  "firmid"
			, "firm"
			, "serieskey" 
})
@Entity
@Table(name="payment_price")
public class PaymentPrice extends SEntity  {

	private static final long serialVersionUID = 7539232157574262L;

	@JsonProperty("id") private Integer id;
	@JsonProperty("paymenttariff") private PaymentTariff paymentTariff;
	@JsonProperty("humannumber") private Integer humannumber;
	@JsonProperty("price") private BigDecimal price;
	private List<ReqServHotel> reqServHotels = new LinkedList<ReqServHotel>();

	public PaymentPrice() {
	}

	public PaymentPrice(int id) {
		this.id = id;
	}

	public PaymentPrice(int id,

 Integer humannumber,
			BigDecimal price,
			List<ReqServHotel> reqServHotels) {
		this.id = id;
		this.paymentTariff = paymentTariff;
		this.humannumber = humannumber;
		this.price = price;
		this.reqServHotels = reqServHotels;
	}

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PAYMENTPRICE")
	@SequenceGenerator(name = "SQ_PAYMENTPRICE", sequenceName = "SQ_PAYMENTPRICE", initialValue = 10, allocationSize = 1)
	@Id
	@Column(name="id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_tariff_id")
	public PaymentTariff getPaymentTariff() {
		return this.paymentTariff;
	}

	public void setPaymentTariff(PaymentTariff paymentTariff) {
		this.paymentTariff = paymentTariff;
	}

	

	

	

	

	@Column(name="humannumber")
	public Integer getHumannumber() {
		return this.humannumber;
	}

	public void setHumannumber(Integer humannumber) {
		this.humannumber = humannumber;
	}

	@Column(name="price", precision = 131089, scale = 0)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="paymentPrice")
	public List<ReqServHotel> getReqServHotels() {
		return this.reqServHotels;
	}

	public void setReqServHotels(List<ReqServHotel> reqServHotels) {
		this.reqServHotels = reqServHotels;
	}

	
// ------------------ Logic part ------------------
	
	@PreRemove
	public void preRemove() {
		for (ReqServHotel arg0 : getReqServHotels()) {
			arg0.setPaymentPrice(null);
		}



		paymentTariff = null;

	}
	
	public PaymentPrice specialInit() {
	
		
		return this;
	}
	
	public PaymentPrice init() {
		initList();
		initDicts();
		
		return this;
	}
	
	public PaymentPrice preInitList() {
		if(getReqServHotels() == null) setReqServHotels(new LinkedList());
		getReqServHotels().parallelStream().forEach(it -> it.setPaymentPrice(this));

		return this;
	}
	
	public PaymentPrice initList() {
		initLists(reqServHotels);

		return this;
	}
	
	public PaymentPrice initDicts() {
		initSentity(getPaymentTariff());

		return this;
	}
	
	
}