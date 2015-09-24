/*
 * 
 */
package org.test.shop.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;














import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;













import org.test.shop.controller.data.types.SimpleDivider;
import org.test.shop.model.domain.SEntity;
import org.test.shop.model.domain.SObject;
import org.test.shop.model.domain.entity.RelServHotelImage;
import org.test.shop.model.domain.entity.RelServHotelRoomImage;
import org.test.shop.model.domain.entity.ReqServHotel;
import org.test.shop.model.domain.entity.ServHotel;
import org.test.shop.model.domain.entity.ServHotelRoom;
import org.test.shop.model.domain.entity.Users;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.view.ShopHotelImagesView;
import org.test.shop.model.domain.entity.view.ShopServHotel2View;
import org.test.shop.util.listner.ReqServHotelListner;
import org.test.shop.util.listner.UsersListner;

// TODO: Auto-generated Javadoc
/**
 * The Class SObjectListner.
 */
@Component
public class SObjectListner {

	
	@Autowired
	private ReqServHotelListner reqServHotelListner;
	@Autowired
	private UsersListner usersListner;
	
	
	/**
	 * Creates the.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public <T> T create(SasUser sasUser, T object){
		if (sasUser == null) {
			return (T) object;
		}
		
		System.out.println("SObjectListner.create()#object: " + object);
		
		if (object instanceof SObject) {
//			SObject sObject = (SObject) object;
			((SObject) object).setFirmid(sasUser.getUser().getFirmid());
			((SObject) object).setCreatedby(sasUser.getUsername());
			((SObject) object).setLastmodifiedby(sasUser.getUsername());
			((SObject) object).setCreateon(new Date());
		}
		
		if (object instanceof ReqServHotel) {
			object = (T) reqServHotelListner.create((ReqServHotel) object, sasUser);
		}
		
		
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T postCreate(SasUser sasUser, T object){
		if (sasUser == null) {
			return (T) object;
		}
		
		
		return (T) object;
	}
	
	/**
	 * Update.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public <T> T update(SasUser sasUser, T object){
		if (object instanceof SObject) {
			((SObject) object).setLastmodifiedby(sasUser.getUsername());
			((SObject) object).setModifyon(new Date());
		}
		
		
		return (T) object;
	}
	
	/**
	 * Delete.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	public <T> T delete(SasUser sasUser, T object){
		
		return (T) object;
	}
	
	/**
	 * View by id.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the t
	 */
	public <T> T viewById(SasUser sasUser, T object){
		
		if (object instanceof ShopServHotel2View) {
			
//			try {
//				if(((ShopServHotel2View) object).getImages() == null || ((ShopServHotel2View) object).getImages().size() == 0){
//					((ShopServHotel2View) object).setImages(new ArrayList<ShopHotelImagesView>());
//				}
//			} catch (Exception e) {
//				((ShopServHotel2View) object).setImages(new ArrayList<ShopHotelImagesView>());
//			}
//			
//			ShopHotelImagesView imagesView = new ShopHotelImagesView();
//			imagesView.setImage("static_default.jpg");
//			((ShopServHotel2View) object).getImages().add(imagesView);
		}
		
		return (T) object;
	}
	
	/**
	 * View.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the list
	 */
	public <T> List<T> view(SasUser sasUser, List<T> object){
		
		if (object.size() > 0) {
			if (object.get(0) instanceof ShopServHotel2View) {
				return (List<T>) new SimpleDivider().divide((List<ShopServHotel2View>) object).result();
			}
		}
		
		return (List<T>) object;
	}
	
	/**
	 * View scrollable.
	 *
	 * @param <T> the generic type
	 * @param sasUser the sas user
	 * @param object the object
	 * @return the list
	 */
	public <T> List<T> viewScrollable(SasUser sasUser, List<T> object){
		
		if (object.size() > 0) {
			if (object.get(0) instanceof ShopServHotel2View) {
				return (List<T>) new SimpleDivider().divide((List<ShopServHotel2View>) object).result();
			}
		}
		
		return (List<T>) object;
	}
	
	public <T> Boolean isSync(T object) {
		if (object instanceof SEntity) {
			return ((SEntity) object).getSync();
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public <T> T preCreate(SasUser sasUser, T object) {
		if (object instanceof SObject) {
//			SObject sObject = (SObject) object;
			((SObject) object).setFirmid(sasUser.getUser().getFirmid());
			((SObject) object).setCreatedby(sasUser.getUsername());
			((SObject) object).setLastmodifiedby(sasUser.getUsername());
			((SObject) object).setCreateon(new Date());
		}
		
		if (object instanceof ReqServHotel) {
			object = (T) reqServHotelListner.create((ReqServHotel) object, sasUser);
		}
		
		if (object instanceof Users) {
			object = (T) usersListner.create((Users) object, sasUser);
		}
		
		return (T) object;
	}

	public <T> T preUpdate(SasUser sasUser, T object) {
		return (T) object;
	}

	public <T> T postUpdate(SasUser sasUser, T object) {
		return (T) object;
	}

	public void preDelete(SasUser sasUser, Class<?> clazz, Object id) {
		
	}
	
	public void postDelete(SasUser sasUser, Class<?> clazz, Object id) {
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T postViewById(SasUser sasUser, T object) {
		
		return (T) object;
	}
	
	public <T> List<T> postView(SasUser sasUser, List<T> objects) {
		return (List<T>) objects;
	}

	public <T> List<T> postViewScrollable(SasUser sasUser, List<T> objects) {
		return (List<T>) objects;
	}

}
