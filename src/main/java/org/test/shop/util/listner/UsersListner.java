package org.test.shop.util.listner;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.RelUserDetails;
import org.test.shop.model.domain.entity.UserDetail;
import org.test.shop.model.domain.entity.UserRoles;
import org.test.shop.model.domain.entity.Users;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.UserDetailService;
import org.test.shop.model.service.other.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersListner {
	
	@Autowired
	private MailService mailService;
	@Autowired
	private UserDetailService detailService;
	private static final boolean ALLOW_SENDING = true;

	@SuppressWarnings("unused")
	public Users create(Users item, SasUser sasUser) {
		if (item.getUsername() == null || item.getUsername().toString().replaceAll("\\s+", "").length() == 0) {
			item.setUsername(item.getEmail());
		}
		
		if (item.getUsername() == null || item.getUsername().toString().replaceAll("\\s+", "").length() == 0) {
			item.setUsername(item.getPhonenumber());
		}
		
		if (item.getUsername() == null || item.getUsername().toString().replaceAll("\\s+", "").length() == 0) {
			throw new RuntimeException("Username can't be null or equals ''");
		}
		
		if(item.getPassword() == null || item.getPassword().toString().replaceAll("\\s+", "").length() == 0){
			throw new RuntimeException("Password can't be null or equals ''");
		}
		
		item.setPassword(new BCryptPasswordEncoder().encode(item.getPassword()));
		item.setUserRoleses(null);
		
		try {
			if (item.getUserRoleses() == null || item.getUserRoleses().size() == 0) {
				item.setUserRoleses(new ArrayList<UserRoles>());
				UserRoles roles = new UserRoles();
				roles.setRole("ROLE_GUEST");
				item.getUserRoleses().add(roles);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			item.getUserRoleses().parallelStream().forEach(it -> {
				it.setUsers(item);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		item.setShopUser(true);
		item.setActivationkey(UUID.randomUUID().toString());
		
		if (item.getPhysicalPerson() == null && item.getLegalEntity() == null) {
			item.setPhysicalPerson(true);
			item.setLegalEntity(false);
		}
		
		if (item.getPhysicalPerson()) {
			if(ALLOW_SENDING && item.getEmail() != null){
				mailService.sendActivationEmail(item);
			}
		}
		
		if (!ALLOW_SENDING) {
			item.setEmail("client.taimax@list.ru");
		}
		
		if(item.getRelUserDetailses() != null && item.getRelUserDetailses().size() > 0){
			List<UserDetail> details = new ArrayList<UserDetail>();
			List<RelUserDetails> list = new ArrayList<RelUserDetails>();
			RelUserDetails relUserDetails = new RelUserDetails();
			
			if(item.getRelUserDetailses() == null || item.getRelUserDetailses().size() == 0){
				item.setRelUserDetailses(new ArrayList<RelUserDetails>());
			}
			
			try {
				UserDetail example = new UserDetail();
				
				if (item.getRelUserDetailses().size() > 0) {
					example.setCompanyName(item.getRelUserDetailses().get(item.getRelUserDetailses().size() - 1).getUserDetail().getCompanyName());
					details = detailService.findByExample(example, " AND ", new ScrollableSettings());
				}
				
			} catch (NullPointerException e) {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(details != null && details.size() > 0){
				relUserDetails.setUserDetail(details.get(0));
			}
			else {
				try {
					if (item.getRelUserDetailses().size() > 0) {
						UserDetail userDetail = item.getRelUserDetailses().get(item.getRelUserDetailses().size() - 1).getUserDetail();
						if (userDetail.getLabel() == null) {
							userDetail.setLabel(userDetail.getCompanyName());
							if (userDetail.getCompanySite() != null) {
								userDetail.setLabel(userDetail.getLabel() + "[" + userDetail.getCompanySite() + "]");
							}
						}
						relUserDetails.setUserDetail(detailService.create(userDetail));
					}
			} catch (NullPointerException e) {
				
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			relUserDetails.setUsers(item);
			list.add(relUserDetails);
			item.setRelUserDetailses(list);
		}
		
		return item;
	}
	
	public Users update(Users item, ScrollableSettings settings) throws Exception {
//		if (item.getUsers() == null) {
//			item.setUsers();
//			ResponseUser(settings.getSasUser().getUsername());
			
//		}
		
		return item;
	}
	
}
