DROP TABLE IF EXISTS public.curr_course_view CASCADE;
DROP TABLE IF EXISTS public.curr_currency_view CASCADE;
DROP TABLE IF EXISTS public.dict_global_view CASCADE;
DROP TABLE IF EXISTS public.doc_documents_view CASCADE;
DROP TABLE IF EXISTS public.group_global_view CASCADE;
DROP TABLE IF EXISTS public.history_serv_hotel_view CASCADE;
DROP TABLE IF EXISTS public.info_contact_information_view CASCADE;
DROP TABLE IF EXISTS public.info_stay_period_view CASCADE;
DROP TABLE IF EXISTS public.location_address_view CASCADE;
DROP TABLE IF EXISTS public.location_cities_view CASCADE;
DROP TABLE IF EXISTS public.location_countries_view CASCADE;
DROP TABLE IF EXISTS public.location_type_placement_view CASCADE;
DROP TABLE IF EXISTS public.payment_details_view CASCADE;
DROP TABLE IF EXISTS public.payment_price_view CASCADE;
DROP TABLE IF EXISTS public.payment_tariff_view CASCADE;
DROP TABLE IF EXISTS public.rel_req_serv_hotel_tm_contact_view CASCADE;
DROP TABLE IF EXISTS public.rel_req_serv_hotel_tm_contact_easy_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_credit_cards_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_dining_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_doc_documents_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_entertainment_and_sport_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_features_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_image_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_info_commercial_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_info_hotel_services_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_info_policies_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_room_features_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_room_image_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_hotel_serv_kids_rule_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_kids_rule_features_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_transfer_tm_contact_view CASCADE;
DROP TABLE IF EXISTS public.rel_serv_transfer_transfer_route_view CASCADE;
DROP TABLE IF EXISTS public.rel_transfer_route_point_view CASCADE;
DROP TABLE IF EXISTS public.req_hotel_rooms_busy_view CASCADE;
DROP TABLE IF EXISTS public.req_serv_hotel_view CASCADE;
DROP TABLE IF EXISTS public.req_serv_hotel_room_busy_view CASCADE;
DROP TABLE IF EXISTS public.serv_hotel_view CASCADE;
DROP TABLE IF EXISTS public.serv_hotel_room_view CASCADE;
DROP TABLE IF EXISTS public.serv_hotel_services_view CASCADE;
DROP TABLE IF EXISTS public.serv_kids_rule_view CASCADE;
DROP TABLE IF EXISTS public.serv_transfer_view CASCADE;
DROP TABLE IF EXISTS public.tm_account_view CASCADE;
DROP TABLE IF EXISTS public.tm_account_addresses_view CASCADE;
DROP TABLE IF EXISTS public.tm_account_communications_view CASCADE;
DROP TABLE IF EXISTS public.tm_account_details_view CASCADE;
DROP TABLE IF EXISTS public.tm_commercial_view CASCADE;
DROP TABLE IF EXISTS public.tm_contact_view CASCADE;
DROP TABLE IF EXISTS public.tm_contact_addresses_view CASCADE;
DROP TABLE IF EXISTS public.tm_contact_communications_view CASCADE;
DROP TABLE IF EXISTS public.tm_contact_easy_view CASCADE;
DROP TABLE IF EXISTS public.tm_firms_view CASCADE;
DROP TABLE IF EXISTS public.tm_image_view CASCADE;
DROP TABLE IF EXISTS public.tm_policies_view CASCADE;
DROP TABLE IF EXISTS public.transfer_route_view CASCADE;
DROP TABLE IF EXISTS public.transfer_route_point_view CASCADE;

DROP VIEW IF EXISTS public.curr_course_view;
DROP VIEW IF EXISTS public.curr_currency_view;
DROP VIEW IF EXISTS public.dict_global_view;
DROP VIEW IF EXISTS public.doc_documents_view;
DROP VIEW IF EXISTS public.group_global_view;
DROP VIEW IF EXISTS public.history_serv_hotel_view;
DROP VIEW IF EXISTS public.info_contact_information_view;
DROP VIEW IF EXISTS public.info_stay_period_view;
DROP VIEW IF EXISTS public.location_address_view;
DROP VIEW IF EXISTS public.location_cities_view;
DROP VIEW IF EXISTS public.location_countries_view;
DROP VIEW IF EXISTS public.location_type_placement_view;
DROP VIEW IF EXISTS public.payment_details_view;
DROP VIEW IF EXISTS public.payment_price_view;
DROP VIEW IF EXISTS public.payment_tariff_view;
DROP VIEW IF EXISTS public.rel_req_serv_hotel_tm_contact_view;
DROP VIEW IF EXISTS public.rel_req_serv_hotel_tm_contact_easy_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_credit_cards_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_dining_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_doc_documents_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_entertainment_and_sport_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_features_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_image_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_info_commercial_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_info_hotel_services_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_info_policies_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_room_features_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_room_image_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_serv_kids_rule_view;
DROP VIEW IF EXISTS public.rel_serv_kids_rule_features_view;
DROP VIEW IF EXISTS public.rel_serv_transfer_tm_contact_view;
DROP VIEW IF EXISTS public.rel_serv_transfer_transfer_route_view;
DROP VIEW IF EXISTS public.rel_transfer_route_point_view;
DROP VIEW IF EXISTS public.req_hotel_rooms_busy_view;
DROP VIEW IF EXISTS public.req_serv_hotel_view;
DROP VIEW IF EXISTS public.req_serv_hotel_room_busy_view;
DROP VIEW IF EXISTS public.serv_hotel_view;
DROP VIEW IF EXISTS public.serv_hotel_room_view;
DROP VIEW IF EXISTS public.serv_hotel_services_view;
DROP VIEW IF EXISTS public.serv_kids_rule_view;
DROP VIEW IF EXISTS public.serv_transfer_view;
DROP VIEW IF EXISTS public.tm_account_view;
DROP VIEW IF EXISTS public.tm_account_addresses_view;
DROP VIEW IF EXISTS public.tm_account_communications_view;
DROP VIEW IF EXISTS public.tm_account_details_view;
DROP VIEW IF EXISTS public.tm_commercial_view;
DROP VIEW IF EXISTS public.tm_contact_view;
DROP VIEW IF EXISTS public.tm_contact_addresses_view;
DROP VIEW IF EXISTS public.tm_contact_communications_view;
DROP VIEW IF EXISTS public.tm_contact_easy_view;
DROP VIEW IF EXISTS public.tm_firms_view;
DROP VIEW IF EXISTS public.tm_image_view;
DROP VIEW IF EXISTS public.tm_policies_view;
DROP VIEW IF EXISTS public.transfer_route_view;
DROP VIEW IF EXISTS public.transfer_route_point_view;

CREATE OR REPLACE VIEW public.curr_course_view 
AS 
select 
  	  public.curr_course.id
	, public.curr_course.version
	, public.curr_course.createby
	, public.curr_course.createon
	, public.curr_course.firmid AS "firm"
	, public.curr_course.modifyby
	, public.curr_course.modifyon
	, public.curr_course.userid AS "user"
	, public.curr_course.label
	, public.curr_course.course
	, public.curr_course.datecourse
	, public.curr_course.createdby
	, public.curr_course.lastmodifiedby
	, curr_currency0.label AS currcurrency
	, curr_currency0.id AS currcurrencyid

from public.curr_course
 LEFT OUTER JOIN public.curr_currency curr_currency0 ON 
 	(public.curr_course.currencyid = 
 	curr_currency0.id)
 ;
	
CREATE OR REPLACE VIEW public.curr_currency_view 
AS 
select 
  	  public.curr_currency.id
	, public.curr_currency.version
	, public.curr_currency.createby
	, public.curr_currency.createon
	, public.curr_currency.firmid AS "firm"
	, public.curr_currency.modifyby
	, public.curr_currency.modifyon
	, public.curr_currency.userid AS "user"
	, public.curr_currency.label
	, public.curr_currency.currencyname
	, public.curr_currency.descr
	, public.curr_currency.isbase
	, public.curr_currency.nameeng
	, public.curr_currency.nameru
	, public.curr_currency.createdby
	, public.curr_currency.lastmodifiedby
from public.curr_currency
;
	
CREATE OR REPLACE VIEW public.dict_global_view 
AS 
select 
  	  public.dict_global.id
	, public.dict_global.label
	, public.dict_global.dict_type AS "dicttype"
	, public.dict_global.dict_value AS "dictvalue"
	, public.dict_global.dict_value_additional AS "dictvalueadditional"
from public.dict_global
;
	
CREATE OR REPLACE VIEW public.doc_documents_view 
AS 
select 
  	  public.doc_documents.id
	, public.doc_documents.version
	, public.doc_documents.createby
	, public.doc_documents.createon
	, public.doc_documents.firmid AS "firm"
	, public.doc_documents.modifyby
	, public.doc_documents.modifyon
	, public.doc_documents.userid AS "user"
	, public.doc_documents.label
	, public.doc_documents.dict_id AS "dict"
	, public.doc_documents.doc_name AS "docname"
	, public.doc_documents.doc_text AS "doctext"
	, public.doc_documents.createdby
	, public.doc_documents.lastmodifiedby
from public.doc_documents
;
	
CREATE OR REPLACE VIEW public.group_global_view 
AS 
select 
  	  public.group_global.id
	, public.group_global.version
	, public.group_global.createby
	, public.group_global.createon
	, public.group_global.firmid AS "firm"
	, public.group_global.modifyby
	, public.group_global.modifyon
	, public.group_global.userid AS "user"
	, public.group_global.label
	, public.group_global.group_type AS "grouptype"
	, public.group_global.group_value AS "groupvalue"
	, public.group_global.createdby
	, public.group_global.lastmodifiedby
from public.group_global
;
	
CREATE OR REPLACE VIEW public.history_serv_hotel_view 
AS 
select 
  	  public.history_serv_hotel.id
	, public.history_serv_hotel.version
	, public.history_serv_hotel.createby
	, public.history_serv_hotel.createon
	, public.history_serv_hotel.firmid AS "firm"
	, public.history_serv_hotel.modifyby
	, public.history_serv_hotel.modifyon
	, public.history_serv_hotel.userid AS "user"
	, public.history_serv_hotel.label
	, public.history_serv_hotel.descr
	, public.history_serv_hotel.createdby
	, public.history_serv_hotel.lastmodifiedby
from public.history_serv_hotel
;
	
CREATE OR REPLACE VIEW public.info_contact_information_view 
AS 
select 
  	  public.info_contact_information.id
	, public.info_contact_information.version
	, public.info_contact_information.createby
	, public.info_contact_information.createon
	, public.info_contact_information.firmid AS "firm"
	, public.info_contact_information.modifyby
	, public.info_contact_information.modifyon
	, public.info_contact_information.userid AS "user"
	, public.info_contact_information.label
	, public.info_contact_information.contact
	, public.info_contact_information.descr
	, public.info_contact_information.phone
	, public.info_contact_information.phone2
	, public.info_contact_information.phone3
	, public.info_contact_information.website
	, public.info_contact_information.createdby
	, public.info_contact_information.lastmodifiedby
from public.info_contact_information
;
	
CREATE OR REPLACE VIEW public.info_stay_period_view 
AS 
select 
  	  public.info_stay_period.id
	, public.info_stay_period.version
	, public.info_stay_period.createby
	, public.info_stay_period.createon
	, public.info_stay_period.firmid AS "firm"
	, public.info_stay_period.modifyby
	, public.info_stay_period.modifyon
	, public.info_stay_period.userid AS "user"
	, public.info_stay_period.label
	, public.info_stay_period.race
	, public.info_stay_period.createdby
	, public.info_stay_period.lastmodifiedby
	, public.info_stay_period.departure
	, req_serv_hotel0.label AS reqservhotel
	, req_serv_hotel0.id AS reqservhotelid

from public.info_stay_period
 LEFT OUTER JOIN public.req_serv_hotel req_serv_hotel0 ON 
 	(public.info_stay_period.req_serv_hotel = 
 	req_serv_hotel0.id)
 ;
	
CREATE OR REPLACE VIEW public.location_address_view 
AS 
select 
  	  public.location_address.id
	, public.location_address.version
	, public.location_address.createby
	, public.location_address.createon
	, public.location_address.firmid AS "firm"
	, public.location_address.modifyby
	, public.location_address.modifyon
	, public.location_address.userid AS "user"
	, public.location_address.label
	, public.location_address.gmap_point_x AS "gmappointx"
	, public.location_address.gmap_point_y AS "gmappointy"
	, public.location_address.metro
	, public.location_address.name
	, public.location_address.nameeng
	, public.location_address.road_map AS "roadmap"
	, public.location_address.yandex_map_point_x AS "yandexmappointx"
	, public.location_address.yandex_map_point_y AS "yandexmappointy"
	, public.location_address.createdby
	, public.location_address.lastmodifiedby
from public.location_address
;
	
CREATE OR REPLACE VIEW public.location_cities_view 
AS 
select 
  	  public.location_cities.id
	, public.location_cities.version
	, public.location_cities.createby
	, public.location_cities.createon
	, public.location_cities.firmid AS "firm"
	, public.location_cities.modifyby
	, public.location_cities.modifyon
	, public.location_cities.userid AS "user"
	, public.location_cities.label
	, public.location_cities.cityname
	, public.location_cities.descr
	, public.location_cities.nameeng
	, public.location_cities.createdby
	, public.location_cities.lastmodifiedby
	, location_countries0.label AS locationcountries
	, location_countries0.id AS locationcountriesid

from public.location_cities
 LEFT OUTER JOIN public.location_countries location_countries0 ON 
 	(public.location_cities.countryid = 
 	location_countries0.id)
 ;
	
CREATE OR REPLACE VIEW public.location_countries_view 
AS 
select 
  	  public.location_countries.id
	, public.location_countries.version
	, public.location_countries.createby
	, public.location_countries.createon
	, public.location_countries.firmid AS "firm"
	, public.location_countries.modifyby
	, public.location_countries.modifyon
	, public.location_countries.userid AS "user"
	, public.location_countries.label
	, public.location_countries.countryname
	, public.location_countries.descr
	, public.location_countries.nameeng
	, public.location_countries.createdby
	, public.location_countries.lastmodifiedby
from public.location_countries
;
	
CREATE OR REPLACE VIEW public.location_type_placement_view 
AS 
select 
  	  public.location_type_placement.id
	, public.location_type_placement.version
	, public.location_type_placement.createby
	, public.location_type_placement.createon
	, public.location_type_placement.firmid AS "firm"
	, public.location_type_placement.modifyby
	, public.location_type_placement.modifyon
	, public.location_type_placement.userid AS "user"
	, public.location_type_placement.label
	, public.location_type_placement.available_number_of_buildings AS "availablenumberofbuildings"
	, public.location_type_placement.available_number_of_levels AS "availablenumberoflevels"
	, public.location_type_placement.available_number_of_rooms AS "availablenumberofrooms"
	, public.location_type_placement.name
	, public.location_type_placement.nameeng
	, public.location_type_placement.number_of_buildings AS "numberofbuildings"
	, public.location_type_placement.number_of_levels AS "numberoflevels"
	, public.location_type_placement.number_of_rooms AS "numberofrooms"
	, public.location_type_placement.serv_hotel_id AS "servhotel"
	, public.location_type_placement.value
	, public.location_type_placement.valueeng
	, public.location_type_placement.createdby
	, public.location_type_placement.lastmodifiedby
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

from public.location_type_placement
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.location_type_placement.type_id = 
 	dict_global0.id)
 ;
	
CREATE OR REPLACE VIEW public.payment_details_view 
AS 
select 
  	  public.payment_details.id
	, public.payment_details.version
	, public.payment_details.createby
	, public.payment_details.createon
	, public.payment_details.firmid AS "firm"
	, public.payment_details.modifyby
	, public.payment_details.modifyon
	, public.payment_details.userid AS "user"
	, public.payment_details.label
	, public.payment_details.bank_location AS "banklocation"
	, public.payment_details.bin
	, public.payment_details.correspondent_account AS "correspondentaccount"
	, public.payment_details.current_account AS "currentaccount"
	, public.payment_details.full_name AS "fullname"
	, public.payment_details.iin
	, public.payment_details.legal_address AS "legaladdress"
	, public.payment_details.name_of_the_bank AS "nameofthebank"
	, public.payment_details.nceo
	, public.payment_details.phone
	, public.payment_details.phone2
	, public.payment_details.postal_address AS "postaladdress"
	, public.payment_details.createdby
	, public.payment_details.lastmodifiedby
from public.payment_details
;
	
CREATE OR REPLACE VIEW public.payment_price_view 
AS 
select 
  	  public.payment_price.id
	, public.payment_price.version
	, public.payment_price.createby
	, public.payment_price.createon
	, public.payment_price.firmid AS "firm"
	, public.payment_price.modifyby
	, public.payment_price.modifyon
	, public.payment_price.userid AS "user"
	, public.payment_price.label
	, public.payment_price.course
	, public.payment_price.value
	, public.payment_price.createdby
	, public.payment_price.lastmodifiedby
	, public.payment_price.discount
	, public.payment_price.commission
	, public.payment_price.humannumber
	, public.payment_price.vat
	, curr_currency0.label AS currcurrency
	, curr_currency0.id AS currcurrencyid

	, payment_tariff1.label AS paymenttariff
	, payment_tariff1.id AS paymenttariffid

from public.payment_price
 LEFT OUTER JOIN public.curr_currency curr_currency0 ON 
 	(public.payment_price.currency_id = 
 	curr_currency0.id)
 
 LEFT OUTER JOIN public.payment_tariff payment_tariff1 ON 
 	(public.payment_price.payment_tariff_id = 
 	payment_tariff1.id)
 ;
	
CREATE OR REPLACE VIEW public.payment_tariff_view 
AS 
select 
  	  public.payment_tariff.id
	, public.payment_tariff.version
	, public.payment_tariff.createby
	, public.payment_tariff.createon
	, public.payment_tariff.firmid AS "firm"
	, public.payment_tariff.modifyby
	, public.payment_tariff.modifyon
	, public.payment_tariff.userid AS "user"
	, public.payment_tariff.label
	, public.payment_tariff.createdby
	, public.payment_tariff.lastmodifiedby
	, public.payment_tariff.synopsys
	, serv_hotel_room0.label AS servhotelroom
	, serv_hotel_room0.id AS servhotelroomid

from public.payment_tariff
 LEFT OUTER JOIN public.serv_hotel_room serv_hotel_room0 ON 
 	(public.payment_tariff.serv_hotel_room_id = 
 	serv_hotel_room0.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_req_serv_hotel_tm_contact_view 
AS 
select 
  	  public.rel_req_serv_hotel_tm_contact.id
	, req_serv_hotel0.label AS reqservhotel
	, req_serv_hotel0.id AS reqservhotelid

	, tm_contact1.label AS tmcontact
	, tm_contact1.id AS tmcontactid

from public.rel_req_serv_hotel_tm_contact
 LEFT OUTER JOIN public.req_serv_hotel req_serv_hotel0 ON 
 	(public.rel_req_serv_hotel_tm_contact.req_serv_hotel_id = 
 	req_serv_hotel0.id)
 
 LEFT OUTER JOIN public.tm_contact tm_contact1 ON 
 	(public.rel_req_serv_hotel_tm_contact.contact_id = 
 	tm_contact1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_req_serv_hotel_tm_contact_easy_view 
AS 
select 
  	  public.rel_req_serv_hotel_tm_contact_easy.id
	, req_serv_hotel0.label AS reqservhotel
	, req_serv_hotel0.id AS reqservhotelid

	, tm_contact_easy1.label AS tmcontacteasy
	, tm_contact_easy1.id AS tmcontacteasyid

from public.rel_req_serv_hotel_tm_contact_easy
 LEFT OUTER JOIN public.req_serv_hotel req_serv_hotel0 ON 
 	(public.rel_req_serv_hotel_tm_contact_easy.req_serv_hotel_id = 
 	req_serv_hotel0.id)
 
 LEFT OUTER JOIN public.tm_contact_easy tm_contact_easy1 ON 
 	(public.rel_req_serv_hotel_tm_contact_easy.contact_easy_id = 
 	tm_contact_easy1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_credit_cards_view 
AS 
select 
  	  public.rel_serv_hotel_credit_cards.id
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel1.label AS servhotel
	, serv_hotel1.id AS servhotelid

from public.rel_serv_hotel_credit_cards
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.rel_serv_hotel_credit_cards.creditcards_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel1 ON 
 	(public.rel_serv_hotel_credit_cards.serv_hotel_id = 
 	serv_hotel1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_dining_view 
AS 
select 
  	  public.rel_serv_hotel_dining.id
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel1.label AS servhotel
	, serv_hotel1.id AS servhotelid

from public.rel_serv_hotel_dining
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.rel_serv_hotel_dining.dining_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel1 ON 
 	(public.rel_serv_hotel_dining.serv_hotel_id = 
 	serv_hotel1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_doc_documents_view 
AS 
select 
  	  public.rel_serv_hotel_doc_documents.id
	, doc_documents0.label AS docdocuments
	, doc_documents0.id AS docdocumentsid

	, serv_hotel1.label AS servhotel
	, serv_hotel1.id AS servhotelid

from public.rel_serv_hotel_doc_documents
 LEFT OUTER JOIN public.doc_documents doc_documents0 ON 
 	(public.rel_serv_hotel_doc_documents.doc_documents_id = 
 	doc_documents0.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel1 ON 
 	(public.rel_serv_hotel_doc_documents.serv_hotel_id = 
 	serv_hotel1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_entertainment_and_sport_view 
AS 
select 
  	  public.rel_serv_hotel_entertainment_and_sport.id
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel1.label AS servhotel
	, serv_hotel1.id AS servhotelid

from public.rel_serv_hotel_entertainment_and_sport
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.rel_serv_hotel_entertainment_and_sport.entertainment_sport_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel1 ON 
 	(public.rel_serv_hotel_entertainment_and_sport.serv_hotel_id = 
 	serv_hotel1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_features_view 
AS 
select 
  	  public.rel_serv_hotel_features.id
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel1.label AS servhotel
	, serv_hotel1.id AS servhotelid

from public.rel_serv_hotel_features
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.rel_serv_hotel_features.feature_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel1 ON 
 	(public.rel_serv_hotel_features.serv_hotel_id = 
 	serv_hotel1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_image_view 
AS 
select 
  	  public.rel_serv_hotel_image.id
	, serv_hotel0.label AS servhotel
	, serv_hotel0.id AS servhotelid

	, tm_image1.name || '.' || tm_image1.extension AS tmimage
	, tm_image1.id AS tmimageid

from public.rel_serv_hotel_image
 LEFT OUTER JOIN public.serv_hotel serv_hotel0 ON 
 	(public.rel_serv_hotel_image.serv_hotel_id = 
 	serv_hotel0.id)
 
 LEFT OUTER JOIN public.tm_image tm_image1 ON 
 	(public.rel_serv_hotel_image.image_id = 
 	tm_image1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_info_commercial_view 
AS 
select 
  	  public.rel_serv_hotel_info_commercial.id
	, serv_hotel0.label AS servhotel
	, serv_hotel0.id AS servhotelid

	, tm_commercial1.label AS tmcommercial
	, tm_commercial1.id AS tmcommercialid

from public.rel_serv_hotel_info_commercial
 LEFT OUTER JOIN public.serv_hotel serv_hotel0 ON 
 	(public.rel_serv_hotel_info_commercial.serv_hotel_id = 
 	serv_hotel0.id)
 
 LEFT OUTER JOIN public.tm_commercial tm_commercial1 ON 
 	(public.rel_serv_hotel_info_commercial.info_commercial_id = 
 	tm_commercial1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_info_hotel_services_view 
AS 
select 
  	  public.rel_serv_hotel_info_hotel_services.id
	, serv_hotel0.label AS servhotel
	, serv_hotel0.id AS servhotelid

	, serv_hotel_services1.label AS servhotelservices
	, serv_hotel_services1.id AS servhotelservicesid

from public.rel_serv_hotel_info_hotel_services
 LEFT OUTER JOIN public.serv_hotel serv_hotel0 ON 
 	(public.rel_serv_hotel_info_hotel_services.serv_hotel_id = 
 	serv_hotel0.id)
 
 LEFT OUTER JOIN public.serv_hotel_services serv_hotel_services1 ON 
 	(public.rel_serv_hotel_info_hotel_services.info_hotel_services_id = 
 	serv_hotel_services1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_info_policies_view 
AS 
select 
  	  public.rel_serv_hotel_info_policies.id
	, serv_hotel0.label AS servhotel
	, serv_hotel0.id AS servhotelid

	, tm_policies1.label AS tmpolicies
	, tm_policies1.id AS tmpoliciesid

from public.rel_serv_hotel_info_policies
 LEFT OUTER JOIN public.serv_hotel serv_hotel0 ON 
 	(public.rel_serv_hotel_info_policies.serv_hotel_id = 
 	serv_hotel0.id)
 
 LEFT OUTER JOIN public.tm_policies tm_policies1 ON 
 	(public.rel_serv_hotel_info_policies.info_policies_id = 
 	tm_policies1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_room_features_view 
AS 
select 
  	  public.rel_serv_hotel_room_features.id
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel_room1.label AS servhotelroom
	, serv_hotel_room1.id AS servhotelroomid

from public.rel_serv_hotel_room_features
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.rel_serv_hotel_room_features.feature_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel_room serv_hotel_room1 ON 
 	(public.rel_serv_hotel_room_features.serv_hotel_room_id = 
 	serv_hotel_room1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_room_image_view 
AS 
select 
  	  public.rel_serv_hotel_room_image.id
	, serv_hotel_room0.label AS servhotelroom
	, serv_hotel_room0.id AS servhotelroomid

	, tm_image1.name || '.' || tm_image1.extension AS tmimage
	, tm_image1.id AS tmimageid

from public.rel_serv_hotel_room_image
 LEFT OUTER JOIN public.serv_hotel_room serv_hotel_room0 ON 
 	(public.rel_serv_hotel_room_image.serv_hotel_room_id = 
 	serv_hotel_room0.id)
 
 LEFT OUTER JOIN public.tm_image tm_image1 ON 
 	(public.rel_serv_hotel_room_image.image_id = 
 	tm_image1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_hotel_serv_kids_rule_view 
AS 
select 
  	  public.rel_serv_hotel_serv_kids_rule.id
	, serv_hotel0.label AS servhotel
	, serv_hotel0.id AS servhotelid

	, serv_kids_rule1.label AS servkidsrule
	, serv_kids_rule1.id AS servkidsruleid

from public.rel_serv_hotel_serv_kids_rule
 LEFT OUTER JOIN public.serv_hotel serv_hotel0 ON 
 	(public.rel_serv_hotel_serv_kids_rule.serv_hotel_id = 
 	serv_hotel0.id)
 
 LEFT OUTER JOIN public.serv_kids_rule serv_kids_rule1 ON 
 	(public.rel_serv_hotel_serv_kids_rule.serv_kids_rule_id = 
 	serv_kids_rule1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_kids_rule_features_view 
AS 
select 
  	  public.rel_serv_kids_rule_features.id
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_kids_rule1.label AS servkidsrule
	, serv_kids_rule1.id AS servkidsruleid

from public.rel_serv_kids_rule_features
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.rel_serv_kids_rule_features.feature_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_kids_rule serv_kids_rule1 ON 
 	(public.rel_serv_kids_rule_features.serv_kids_rule_id = 
 	serv_kids_rule1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_transfer_tm_contact_view 
AS 
select 
  	  public.rel_serv_transfer_tm_contact.id
	, serv_transfer0.label AS servtransfer
	, serv_transfer0.id AS servtransferid

	, tm_contact1.label AS tmcontact
	, tm_contact1.id AS tmcontactid

from public.rel_serv_transfer_tm_contact
 LEFT OUTER JOIN public.serv_transfer serv_transfer0 ON 
 	(public.rel_serv_transfer_tm_contact.serv_transfers_id = 
 	serv_transfer0.id)
 
 LEFT OUTER JOIN public.tm_contact tm_contact1 ON 
 	(public.rel_serv_transfer_tm_contact.tm_contact_id = 
 	tm_contact1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_serv_transfer_transfer_route_view 
AS 
select 
  	  public.rel_serv_transfer_transfer_route.id
	, serv_transfer0.label AS servtransfer
	, serv_transfer0.id AS servtransferid

	, transfer_route1.label AS transferroute
	, transfer_route1.id AS transferrouteid

from public.rel_serv_transfer_transfer_route
 LEFT OUTER JOIN public.serv_transfer serv_transfer0 ON 
 	(public.rel_serv_transfer_transfer_route.serv_transfers_id = 
 	serv_transfer0.id)
 
 LEFT OUTER JOIN public.transfer_route transfer_route1 ON 
 	(public.rel_serv_transfer_transfer_route.transfer_route_id = 
 	transfer_route1.id)
 ;
	
CREATE OR REPLACE VIEW public.rel_transfer_route_point_view 
AS 
select 
  	  public.rel_transfer_route_point.id
	, transfer_route0.label AS transferroute
	, transfer_route0.id AS transferrouteid

	, transfer_route_point1.label AS transferroutepoint
	, transfer_route_point1.id AS transferroutepointid

from public.rel_transfer_route_point
 LEFT OUTER JOIN public.transfer_route transfer_route0 ON 
 	(public.rel_transfer_route_point.transfer_route_id = 
 	transfer_route0.id)
 
 LEFT OUTER JOIN public.transfer_route_point transfer_route_point1 ON 
 	(public.rel_transfer_route_point.transfer_route_point_id = 
 	transfer_route_point1.id)
 ;
	
CREATE OR REPLACE VIEW public.req_hotel_rooms_busy_view 
AS 
select 
  	  public.req_hotel_rooms_busy.id
	, public.req_hotel_rooms_busy.version
	, public.req_hotel_rooms_busy.createby
	, public.req_hotel_rooms_busy.createon
	, public.req_hotel_rooms_busy.firmid AS "firm"
	, public.req_hotel_rooms_busy.modifyby
	, public.req_hotel_rooms_busy.modifyon
	, public.req_hotel_rooms_busy.userid AS "user"
	, public.req_hotel_rooms_busy.label
	, public.req_hotel_rooms_busy.busy_end AS "busyend"
	, public.req_hotel_rooms_busy.busy_start AS "busystart"
	, public.req_hotel_rooms_busy.createdby
	, public.req_hotel_rooms_busy.lastmodifiedby
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel_room1.label AS servhotelroom
	, serv_hotel_room1.id AS servhotelroomid

from public.req_hotel_rooms_busy
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.req_hotel_rooms_busy.busy_type_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel_room serv_hotel_room1 ON 
 	(public.req_hotel_rooms_busy.room_id = 
 	serv_hotel_room1.id)
 ;
	
CREATE OR REPLACE VIEW public.req_serv_hotel_view 
AS 
select 
  	  public.req_serv_hotel.id
	, public.req_serv_hotel.version
	, public.req_serv_hotel.createby
	, public.req_serv_hotel.createon
	, public.req_serv_hotel.firmid AS "firm"
	, public.req_serv_hotel.modifyby
	, public.req_serv_hotel.modifyon
	, public.req_serv_hotel.userid AS "user"
	, public.req_serv_hotel.label
	, public.req_serv_hotel.approved
	, public.req_serv_hotel.descr
	, public.req_serv_hotel.createdby
	, public.req_serv_hotel.lastmodifiedby
	, public.req_serv_hotel.room_count AS "roomcount"
	, public.req_serv_hotel.price
	, public.req_serv_hotel.cancel_prepayment AS "cancelprepayment"
	, public.req_serv_hotel.change_prepayment AS "changeprepayment"
	, dict_global0.label AS dictglobalbystatus
	, dict_global0.id AS dictglobalbystatusid

	, dict_global1.label AS dictglobalbyplacement
	, dict_global1.id AS dictglobalbyplacementid

	, dict_global2.label AS dictglobalbypaymenttype
	, dict_global2.id AS dictglobalbypaymenttypeid

	, dict_global3.label AS dictglobalbyfood
	, dict_global3.id AS dictglobalbyfoodid

	, serv_hotel4.label AS servhotel
	, serv_hotel4.id AS servhotelid

	, serv_hotel_room5.label AS servhotelroom
	, serv_hotel_room5.id AS servhotelroomid

	, tm_account6.label AS tmaccount
	, tm_account6.id AS tmaccountid

	, tm_contact7.label AS tmcontact
	, tm_contact7.id AS tmcontactid

from public.req_serv_hotel
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.req_serv_hotel.status_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.dict_global dict_global1 ON 
 	(public.req_serv_hotel.placement_id = 
 	dict_global1.id)
 
 LEFT OUTER JOIN public.dict_global dict_global2 ON 
 	(public.req_serv_hotel.payment_type_id = 
 	dict_global2.id)
 
 LEFT OUTER JOIN public.dict_global dict_global3 ON 
 	(public.req_serv_hotel.food_id = 
 	dict_global3.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel4 ON 
 	(public.req_serv_hotel.serv_hotel_id = 
 	serv_hotel4.id)
 
 LEFT OUTER JOIN public.serv_hotel_room serv_hotel_room5 ON 
 	(public.req_serv_hotel.serv_hotel_room_id = 
 	serv_hotel_room5.id)
 
 LEFT OUTER JOIN public.tm_account tm_account6 ON 
 	(public.req_serv_hotel.request_account_id = 
 	tm_account6.id)
 
 LEFT OUTER JOIN public.tm_contact tm_contact7 ON 
 	(public.req_serv_hotel.request_contact_id = 
 	tm_contact7.id)
 ;
	
CREATE OR REPLACE VIEW public.req_serv_hotel_room_busy_view 
AS 
select 
  	  public.req_serv_hotel_room_busy.id
	, public.req_serv_hotel_room_busy.version
	, public.req_serv_hotel_room_busy.busy_end AS "busyend"
	, public.req_serv_hotel_room_busy.busy_start AS "busystart"
	, public.req_serv_hotel_room_busy.createby
	, public.req_serv_hotel_room_busy.createdby
	, public.req_serv_hotel_room_busy.createon
	, public.req_serv_hotel_room_busy.firmid AS "firm"
	, public.req_serv_hotel_room_busy.lastmodifiedby
	, public.req_serv_hotel_room_busy.modifyby
	, public.req_serv_hotel_room_busy.modifyon
	, public.req_serv_hotel_room_busy.userid AS "user"
	, public.req_serv_hotel_room_busy.label
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, serv_hotel_room1.label AS servhotelroom
	, serv_hotel_room1.id AS servhotelroomid

from public.req_serv_hotel_room_busy
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.req_serv_hotel_room_busy.busy_type_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.serv_hotel_room serv_hotel_room1 ON 
 	(public.req_serv_hotel_room_busy.room_id = 
 	serv_hotel_room1.id)
 ;
	
CREATE OR REPLACE VIEW public.serv_hotel_view 
AS 
select 
  	  public.serv_hotel.id
	, public.serv_hotel.version
	, public.serv_hotel.createby
	, public.serv_hotel.createon
	, public.serv_hotel.firmid AS "firm"
	, public.serv_hotel.modifyby
	, public.serv_hotel.modifyon
	, public.serv_hotel.userid AS "user"
	, public.serv_hotel.label
	, public.serv_hotel.bat
	, public.serv_hotel.blacklist
	, public.serv_hotel.credit
	, public.serv_hotel.crediteasy
	, public.serv_hotel.descr
	, public.serv_hotel.descr_internal AS "descrinternal"
	, public.serv_hotel.favorite
	, public.serv_hotel.hch
	, public.serv_hotel.nameeng
	, public.serv_hotel.problem
	, public.serv_hotel.reservetickets
	, public.serv_hotel.roomsnumber
	, public.serv_hotel.showonline
	, public.serv_hotel.starcount
	, public.serv_hotel.storeys
	, public.serv_hotel.whereroomsarebooked
	, public.serv_hotel.withoutdelayingpayment
	, public.serv_hotel.withoutfreesale
	, public.serv_hotel.workonprepayment
	, public.serv_hotel.createdby
	, public.serv_hotel.lastmodifiedby
	, curr_currency0.label AS currcurrency
	, curr_currency0.id AS currcurrencyid

	, dict_global1.label AS dictglobalbyserviceid
	, dict_global1.id AS dictglobalbyserviceidid

	, dict_global2.label AS dictglobalbyreserveticketstype
	, dict_global2.id AS dictglobalbyreserveticketstypeid

	, dict_global3.label AS dictglobalbyplacement
	, dict_global3.id AS dictglobalbyplacementid

	, dict_global4.label AS dictglobalbytype
	, dict_global4.id AS dictglobalbytypeid

	, dict_global5.label AS dictglobalbycredittype
	, dict_global5.id AS dictglobalbycredittypeid

	, dict_global6.label AS dictglobalbycategory
	, dict_global6.id AS dictglobalbycategoryid

	, dict_global7.label AS dictglobalbyquality
	, dict_global7.id AS dictglobalbyqualityid

	, info_contact_information8.label AS infocontactinformation
	, info_contact_information8.id AS infocontactinformationid

	, location_address9.label AS locationaddress
	, location_address9.id AS locationaddressid

	, location_cities10.label AS locationcities
	, location_cities10.id AS locationcitiesid

	, location_countries11.label AS locationcountries
	, location_countries11.id AS locationcountriesid

	, location_type_placement12.label AS locationtypeplacement
	, location_type_placement12.id AS locationtypeplacementid

	, payment_details13.label AS paymentdetails
	, payment_details13.id AS paymentdetailsid

	, tm_account14.label AS tmaccount
	, tm_account14.id AS tmaccountid

from public.serv_hotel
 LEFT OUTER JOIN public.curr_currency curr_currency0 ON 
 	(public.serv_hotel.currency_id = 
 	curr_currency0.id)
 
 LEFT OUTER JOIN public.dict_global dict_global1 ON 
 	(public.serv_hotel.serviceid_id = 
 	dict_global1.id)
 
 LEFT OUTER JOIN public.dict_global dict_global2 ON 
 	(public.serv_hotel.reserveticketstype_id = 
 	dict_global2.id)
 
 LEFT OUTER JOIN public.dict_global dict_global3 ON 
 	(public.serv_hotel.placement_id = 
 	dict_global3.id)
 
 LEFT OUTER JOIN public.dict_global dict_global4 ON 
 	(public.serv_hotel.type_id = 
 	dict_global4.id)
 
 LEFT OUTER JOIN public.dict_global dict_global5 ON 
 	(public.serv_hotel.credittype_id = 
 	dict_global5.id)
 
 LEFT OUTER JOIN public.dict_global dict_global6 ON 
 	(public.serv_hotel.category_id = 
 	dict_global6.id)
 
 LEFT OUTER JOIN public.dict_global dict_global7 ON 
 	(public.serv_hotel.quality_id = 
 	dict_global7.id)
 
 LEFT OUTER JOIN public.info_contact_information info_contact_information8 ON 
 	(public.serv_hotel.contactinformation_id = 
 	info_contact_information8.id)
 
 LEFT OUTER JOIN public.location_address location_address9 ON 
 	(public.serv_hotel.address_id = 
 	location_address9.id)
 
 LEFT OUTER JOIN public.location_cities location_cities10 ON 
 	(public.serv_hotel.locationcities_id = 
 	location_cities10.id)
 
 LEFT OUTER JOIN public.location_countries location_countries11 ON 
 	(public.serv_hotel.locationcountries_id = 
 	location_countries11.id)
 
 LEFT OUTER JOIN public.location_type_placement location_type_placement12 ON 
 	(public.serv_hotel.location_type_placement_id = 
 	location_type_placement12.id)
 
 LEFT OUTER JOIN public.payment_details payment_details13 ON 
 	(public.serv_hotel.payment_details_id = 
 	payment_details13.id)
 
 LEFT OUTER JOIN public.tm_account tm_account14 ON 
 	(public.serv_hotel.tmaccounts_id = 
 	tm_account14.id)
 ;
	
CREATE OR REPLACE VIEW public.serv_hotel_room_view 
AS 
select 
  	  public.serv_hotel_room.id
	, public.serv_hotel_room.version
	, public.serv_hotel_room.createby
	, public.serv_hotel_room.createon
	, public.serv_hotel_room.firmid AS "firm"
	, public.serv_hotel_room.modifyby
	, public.serv_hotel_room.modifyon
	, public.serv_hotel_room.userid AS "user"
	, public.serv_hotel_room.label
	, public.serv_hotel_room.descr
	, public.serv_hotel_room.guest_number AS "guestnumber"
	, public.serv_hotel_room.room_number AS "roomnumber"
	, public.serv_hotel_room.createdby
	, public.serv_hotel_room.lastmodifiedby
	, public.serv_hotel_room.breakfast
	, dict_global0.label AS dictglobalbyfood
	, dict_global0.id AS dictglobalbyfoodid

	, dict_global1.label AS dictglobalbyroomtype
	, dict_global1.id AS dictglobalbyroomtypeid

	, group_global2.label AS groupglobal
	, group_global2.id AS groupglobalid

	, serv_hotel3.label AS servhotel
	, serv_hotel3.id AS servhotelid

from public.serv_hotel_room
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.serv_hotel_room.food_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.dict_global dict_global1 ON 
 	(public.serv_hotel_room.room_type_id = 
 	dict_global1.id)
 
 LEFT OUTER JOIN public.group_global group_global2 ON 
 	(public.serv_hotel_room.group_id = 
 	group_global2.id)
 
 LEFT OUTER JOIN public.serv_hotel serv_hotel3 ON 
 	(public.serv_hotel_room.hotel_id = 
 	serv_hotel3.id)
 ;
	
CREATE OR REPLACE VIEW public.serv_hotel_services_view 
AS 
select 
  	  public.serv_hotel_services.id
	, public.serv_hotel_services.version
	, public.serv_hotel_services.createby
	, public.serv_hotel_services.createon
	, public.serv_hotel_services.firmid AS "firm"
	, public.serv_hotel_services.modifyby
	, public.serv_hotel_services.modifyon
	, public.serv_hotel_services.userid AS "user"
	, public.serv_hotel_services.label
	, public.serv_hotel_services.synopsys
	, public.serv_hotel_services.name
	, public.serv_hotel_services.createdby
	, public.serv_hotel_services.lastmodifiedby
	, dict_global0.label AS dictglobalbyfeature
	, dict_global0.id AS dictglobalbyfeatureid

	, dict_global1.label AS dictglobalbyservice
	, dict_global1.id AS dictglobalbyserviceid

from public.serv_hotel_services
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.serv_hotel_services.feature_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.dict_global dict_global1 ON 
 	(public.serv_hotel_services.service_id = 
 	dict_global1.id)
 ;
	
CREATE OR REPLACE VIEW public.serv_kids_rule_view 
AS 
select 
  	  public.serv_kids_rule.id
	, public.serv_kids_rule.version
	, public.serv_kids_rule.createby
	, public.serv_kids_rule.createon
	, public.serv_kids_rule.firmid AS "firm"
	, public.serv_kids_rule.modifyby
	, public.serv_kids_rule.modifyon
	, public.serv_kids_rule.userid AS "user"
	, public.serv_kids_rule.label
	, public.serv_kids_rule.synopsys
	, public.serv_kids_rule.end_age AS "endage"
	, public.serv_kids_rule.name
	, public.serv_kids_rule.start_age AS "startage"
	, public.serv_kids_rule.createdby
	, public.serv_kids_rule.lastmodifiedby
from public.serv_kids_rule
;
	
CREATE OR REPLACE VIEW public.serv_transfer_view 
AS 
select 
  	  public.serv_transfer.id
	, public.serv_transfer.version
	, public.serv_transfer.createby
	, public.serv_transfer.createon
	, public.serv_transfer.firmid AS "firm"
	, public.serv_transfer.modifyby
	, public.serv_transfer.modifyon
	, public.serv_transfer.userid AS "user"
	, public.serv_transfer.label
	, public.serv_transfer.date_from AS "datefrom"
	, public.serv_transfer.date_to AS "dateto"
	, public.serv_transfer.descr
	, public.serv_transfer.passengers_phones AS "passengersphones"
	, public.serv_transfer.price
	, public.serv_transfer.transfer_name AS "transfername"
	, public.serv_transfer.visit_table AS "visittable"
	, public.serv_transfer.createdby
	, public.serv_transfer.lastmodifiedby
	, curr_currency0.label AS currcurrency
	, curr_currency0.id AS currcurrencyid

	, dict_global1.label AS dictglobalbytransport
	, dict_global1.id AS dictglobalbytransportid

	, dict_global2.label AS dictglobalbypaymenttype
	, dict_global2.id AS dictglobalbypaymenttypeid

	, dict_global3.label AS dictglobalbytypetransfer
	, dict_global3.id AS dictglobalbytypetransferid

	, location_cities4.label AS locationcities
	, location_cities4.id AS locationcitiesid

	, location_countries5.label AS locationcountries
	, location_countries5.id AS locationcountriesid

	, tm_account6.label AS tmaccount
	, tm_account6.id AS tmaccountid

from public.serv_transfer
 LEFT OUTER JOIN public.curr_currency curr_currency0 ON 
 	(public.serv_transfer.currency_id = 
 	curr_currency0.id)
 
 LEFT OUTER JOIN public.dict_global dict_global1 ON 
 	(public.serv_transfer.transport_id = 
 	dict_global1.id)
 
 LEFT OUTER JOIN public.dict_global dict_global2 ON 
 	(public.serv_transfer.payment_type_id = 
 	dict_global2.id)
 
 LEFT OUTER JOIN public.dict_global dict_global3 ON 
 	(public.serv_transfer.type_transfer_id = 
 	dict_global3.id)
 
 LEFT OUTER JOIN public.location_cities location_cities4 ON 
 	(public.serv_transfer.location_cities_id = 
 	location_cities4.id)
 
 LEFT OUTER JOIN public.location_countries location_countries5 ON 
 	(public.serv_transfer.location_countries_id = 
 	location_countries5.id)
 
 LEFT OUTER JOIN public.tm_account tm_account6 ON 
 	(public.serv_transfer.account_id = 
 	tm_account6.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_account_view 
AS 
select 
  	  public.tm_account.id
	, public.tm_account.version
	, public.tm_account.createby
	, public.tm_account.createon
	, public.tm_account.firmid AS "firm"
	, public.tm_account.modifyby
	, public.tm_account.modifyon
	, public.tm_account.userid AS "user"
	, public.tm_account.label
	, public.tm_account.account_fullname AS "accountfullname"
	, public.tm_account.account_name AS "accountname"
	, public.tm_account.citizenship
	, public.tm_account.descr
	, public.tm_account.groupid AS "group"
	, public.tm_account.name_eng AS "nameeng"
	, public.tm_account.tourlisence
	, public.tm_account.tourlisence_file AS "tourlisencefile"
	, public.tm_account.createdby
	, public.tm_account.lastmodifiedby
from public.tm_account
;
	
CREATE OR REPLACE VIEW public.tm_account_addresses_view 
AS 
select 
  	  public.tm_account_addresses.id
	, public.tm_account_addresses.version
	, public.tm_account_addresses.createby
	, public.tm_account_addresses.createon
	, public.tm_account_addresses.firmid AS "firm"
	, public.tm_account_addresses.modifyby
	, public.tm_account_addresses.modifyon
	, public.tm_account_addresses.userid AS "user"
	, public.tm_account_addresses.label
	, public.tm_account_addresses.address
	, public.tm_account_addresses.address_name AS "addressname"
	, public.tm_account_addresses.descr
	, public.tm_account_addresses.is_detail AS "isdetail"
	, public.tm_account_addresses.zip
	, public.tm_account_addresses.createdby
	, public.tm_account_addresses.lastmodifiedby
	, location_cities0.label AS locationcities
	, location_cities0.id AS locationcitiesid

	, tm_account1.label AS tmaccount
	, tm_account1.id AS tmaccountid

from public.tm_account_addresses
 LEFT OUTER JOIN public.location_cities location_cities0 ON 
 	(public.tm_account_addresses.city_id = 
 	location_cities0.id)
 
 LEFT OUTER JOIN public.tm_account tm_account1 ON 
 	(public.tm_account_addresses.accountid = 
 	tm_account1.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_account_communications_view 
AS 
select 
  	  public.tm_account_communications.id
	, public.tm_account_communications.version
	, public.tm_account_communications.createby
	, public.tm_account_communications.createon
	, public.tm_account_communications.firmid AS "firm"
	, public.tm_account_communications.modifyby
	, public.tm_account_communications.modifyon
	, public.tm_account_communications.userid AS "user"
	, public.tm_account_communications.label
	, public.tm_account_communications.communication_name AS "communicationname"
	, public.tm_account_communications.communication_value AS "communicationvalue"
	, public.tm_account_communications.descr
	, public.tm_account_communications.is_detail AS "isdetail"
	, public.tm_account_communications.createdby
	, public.tm_account_communications.lastmodifiedby
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, location_cities1.label AS locationcities
	, location_cities1.id AS locationcitiesid

	, tm_account2.label AS tmaccount
	, tm_account2.id AS tmaccountid

from public.tm_account_communications
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.tm_account_communications.communication_type_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.location_cities location_cities1 ON 
 	(public.tm_account_communications.city_id = 
 	location_cities1.id)
 
 LEFT OUTER JOIN public.tm_account tm_account2 ON 
 	(public.tm_account_communications.accountid = 
 	tm_account2.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_account_details_view 
AS 
select 
  	  public.tm_account_details.id
	, public.tm_account_details.version
	, public.tm_account_details.createby
	, public.tm_account_details.createon
	, public.tm_account_details.firmid AS "firm"
	, public.tm_account_details.modifyby
	, public.tm_account_details.modifyon
	, public.tm_account_details.userid AS "user"
	, public.tm_account_details.label
	, public.tm_account_details.bank_id AS "bank"
	, public.tm_account_details.bankaccount
	, public.tm_account_details.bik
	, public.tm_account_details.bin
	, public.tm_account_details.is_base AS "isbase"
	, public.tm_account_details.is_detail AS "isdetail"
	, public.tm_account_details.rnn
	, public.tm_account_details.createdby
	, public.tm_account_details.lastmodifiedby
	, tm_account0.label AS tmaccount
	, tm_account0.id AS tmaccountid

from public.tm_account_details
 LEFT OUTER JOIN public.tm_account tm_account0 ON 
 	(public.tm_account_details.account_id = 
 	tm_account0.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_commercial_view 
AS 
select 
  	  public.tm_commercial.id
	, public.tm_commercial.version
	, public.tm_commercial.createby
	, public.tm_commercial.createon
	, public.tm_commercial.firmid AS "firm"
	, public.tm_commercial.modifyby
	, public.tm_commercial.modifyon
	, public.tm_commercial.userid AS "user"
	, public.tm_commercial.label
	, public.tm_commercial.descr
	, public.tm_commercial.name
	, public.tm_commercial.createdby
	, public.tm_commercial.lastmodifiedby
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

from public.tm_commercial
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.tm_commercial.feature_id = 
 	dict_global0.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_contact_view 
AS 
select 
  	  public.tm_contact.id
	, public.tm_contact.version
	, public.tm_contact.createby
	, public.tm_contact.createon
	, public.tm_contact.firmid AS "firm"
	, public.tm_contact.modifyby
	, public.tm_contact.modifyon
	, public.tm_contact.userid AS "user"
	, public.tm_contact.label
	, public.tm_contact.birthday
	, public.tm_contact.citizenship
	, public.tm_contact.contact_guid AS "contactgu"
	, public.tm_contact.contact_name AS "contactname"
	, public.tm_contact.contact_patronymic AS "contactpatronymic"
	, public.tm_contact.contact_surname AS "contactsurname"
	, public.tm_contact.descr
	, public.tm_contact.groupid AS "group"
	, public.tm_contact.name_eng AS "nameeng"
	, public.tm_contact.passport_end_date AS "passportenddate"
	, public.tm_contact.passport_number AS "passportnumber"
	, public.tm_contact.passport_start_date AS "passportstartdate"
	, public.tm_contact.patronymic_eng AS "patronymiceng"
	, public.tm_contact.position
	, public.tm_contact.sertification_end_date AS "sertificationenddate"
	, public.tm_contact.sertification_number AS "sertificationnumber"
	, public.tm_contact.sertification_start_date AS "sertificationstartdate"
	, public.tm_contact.surname_eng AS "surnameeng"
	, public.tm_contact.tmfirms
	, public.tm_contact.createdby
	, public.tm_contact.lastmodifiedby
from public.tm_contact
;
	
CREATE OR REPLACE VIEW public.tm_contact_addresses_view 
AS 
select 
  	  public.tm_contact_addresses.id
	, public.tm_contact_addresses.version
	, public.tm_contact_addresses.createby
	, public.tm_contact_addresses.createon
	, public.tm_contact_addresses.firmid AS "firm"
	, public.tm_contact_addresses.modifyby
	, public.tm_contact_addresses.modifyon
	, public.tm_contact_addresses.userid AS "user"
	, public.tm_contact_addresses.label
	, public.tm_contact_addresses.address
	, public.tm_contact_addresses.address_name AS "addressname"
	, public.tm_contact_addresses.descr
	, public.tm_contact_addresses.zip
	, public.tm_contact_addresses.createdby
	, public.tm_contact_addresses.lastmodifiedby
	, location_cities0.label AS locationcities
	, location_cities0.id AS locationcitiesid

	, tm_contact1.label AS tmcontact
	, tm_contact1.id AS tmcontactid

from public.tm_contact_addresses
 LEFT OUTER JOIN public.location_cities location_cities0 ON 
 	(public.tm_contact_addresses.city_id = 
 	location_cities0.id)
 
 LEFT OUTER JOIN public.tm_contact tm_contact1 ON 
 	(public.tm_contact_addresses.contact_id = 
 	tm_contact1.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_contact_communications_view 
AS 
select 
  	  public.tm_contact_communications.id
	, public.tm_contact_communications.version
	, public.tm_contact_communications.createby
	, public.tm_contact_communications.createon
	, public.tm_contact_communications.firmid AS "firm"
	, public.tm_contact_communications.modifyby
	, public.tm_contact_communications.modifyon
	, public.tm_contact_communications.userid AS "user"
	, public.tm_contact_communications.label
	, public.tm_contact_communications.communication_name AS "communicationname"
	, public.tm_contact_communications.communication_value AS "communicationvalue"
	, public.tm_contact_communications.descr
	, public.tm_contact_communications.createdby
	, public.tm_contact_communications.lastmodifiedby
	, dict_global0.label AS dictglobal
	, dict_global0.id AS dictglobalid

	, location_cities1.label AS locationcities
	, location_cities1.id AS locationcitiesid

	, tm_contact2.label AS tmcontact
	, tm_contact2.id AS tmcontactid

from public.tm_contact_communications
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.tm_contact_communications.communication_type_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.location_cities location_cities1 ON 
 	(public.tm_contact_communications.city_id = 
 	location_cities1.id)
 
 LEFT OUTER JOIN public.tm_contact tm_contact2 ON 
 	(public.tm_contact_communications.contact_id = 
 	tm_contact2.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_contact_easy_view 
AS 
select 
  	  public.tm_contact_easy.id
	, public.tm_contact_easy.version
	, public.tm_contact_easy.label
	, public.tm_contact_easy.man_foman AS "manfoman"
	, public.tm_contact_easy.descr
	, public.tm_contact_easy.createby
	, public.tm_contact_easy.createdby
	, public.tm_contact_easy.createon
	, public.tm_contact_easy.firmid AS "firm"
	, public.tm_contact_easy.lastmodifiedby
	, public.tm_contact_easy.modifyby
	, public.tm_contact_easy.modifyon
	, public.tm_contact_easy.userid AS "user"
	, location_countries0.label AS locationcountries
	, location_countries0.id AS locationcountriesid

from public.tm_contact_easy
 LEFT OUTER JOIN public.location_countries location_countries0 ON 
 	(public.tm_contact_easy.country_id = 
 	location_countries0.id)
 ;
	
CREATE OR REPLACE VIEW public.tm_firms_view 
AS 
select 
  	  public.tm_firms.id
	, public.tm_firms.version
	, public.tm_firms.createby
	, public.tm_firms.createon
	, public.tm_firms.firmid AS "firm"
	, public.tm_firms.modifyby
	, public.tm_firms.modifyon
	, public.tm_firms.userid AS "user"
	, public.tm_firms.label
	, public.tm_firms.accountid AS "account"
	, public.tm_firms.active
	, public.tm_firms.firm_name AS "firmname"
	, public.tm_firms.lastpay
	, public.tm_firms.mounthcount
	, public.tm_firms.createdby
	, public.tm_firms.lastmodifiedby
from public.tm_firms
;
	
CREATE OR REPLACE VIEW public.tm_image_view 
AS 
select 
  	  public.tm_image.id
	, public.tm_image.version
	, public.tm_image.createby
	, public.tm_image.createon
	, public.tm_image.firmid AS "firm"
	, public.tm_image.modifyby
	, public.tm_image.modifyon
	, public.tm_image.userid AS "user"
	, public.tm_image.contenttype
	, public.tm_image.extension
	, public.tm_image.name
	, public.tm_image.originalfilename
	, public.tm_image.path
	, public.tm_image.size
	, public.tm_image.createdby
	, public.tm_image.lastmodifiedby
from public.tm_image
;
	
CREATE OR REPLACE VIEW public.tm_policies_view 
AS 
select 
  	  public.tm_policies.id
	, public.tm_policies.version
	, public.tm_policies.createby
	, public.tm_policies.createon
	, public.tm_policies.firmid AS "firm"
	, public.tm_policies.modifyby
	, public.tm_policies.modifyon
	, public.tm_policies.userid AS "user"
	, public.tm_policies.label
	, public.tm_policies.cancel_prepayment AS "cancelprepayment"
	, public.tm_policies.children_and_extra_beds AS "childrenandextrabeds"
	, public.tm_policies.departure
	, public.tm_policies.descr
	, public.tm_policies.name
	, public.tm_policies.pets
	, public.tm_policies.race
	, public.tm_policies.createdby
	, public.tm_policies.lastmodifiedby
	, public.tm_policies.change_prepayment AS "changeprepayment"
	, dict_global0.label AS dictglobalbyfeature
	, dict_global0.id AS dictglobalbyfeatureid

	, dict_global1.label AS dictglobalbyservice
	, dict_global1.id AS dictglobalbyserviceid

from public.tm_policies
 LEFT OUTER JOIN public.dict_global dict_global0 ON 
 	(public.tm_policies.feature_id = 
 	dict_global0.id)
 
 LEFT OUTER JOIN public.dict_global dict_global1 ON 
 	(public.tm_policies.service_id = 
 	dict_global1.id)
 ;
	
CREATE OR REPLACE VIEW public.transfer_route_view 
AS 
select 
  	  public.transfer_route.id
	, public.transfer_route.version
	, public.transfer_route.createby
	, public.transfer_route.createon
	, public.transfer_route.firmid AS "firm"
	, public.transfer_route.modifyby
	, public.transfer_route.modifyon
	, public.transfer_route.userid AS "user"
	, public.transfer_route.label
	, public.transfer_route.currency_id AS "currency"
	, public.transfer_route.descr
	, public.transfer_route.driver
	, public.transfer_route.driver_phone AS "driverphone"
	, public.transfer_route.fixed_allowance AS "fixedallowance"
	, public.transfer_route.free
	, public.transfer_route.percentage_of_allowances AS "percentageofallowances"
	, public.transfer_route.sum
	, public.transfer_route.createdby
	, public.transfer_route.lastmodifiedby
from public.transfer_route
;
	
CREATE OR REPLACE VIEW public.transfer_route_point_view 
AS 
select 
  	  public.transfer_route_point.id
	, public.transfer_route_point.version
	, public.transfer_route_point.createby
	, public.transfer_route_point.createon
	, public.transfer_route_point.firmid AS "firm"
	, public.transfer_route_point.modifyby
	, public.transfer_route_point.modifyon
	, public.transfer_route_point.userid AS "user"
	, public.transfer_route_point.label
	, public.transfer_route_point.fixed_allowance AS "fixedallowance"
	, public.transfer_route_point.free
	, public.transfer_route_point.percentage_of_allowances AS "percentageofallowances"
	, public.transfer_route_point.point_from AS "pointfrom"
	, public.transfer_route_point.point_to AS "pointto"
	, public.transfer_route_point.start_on AS "starton"
	, public.transfer_route_point.sum
	, public.transfer_route_point.createdby
	, public.transfer_route_point.lastmodifiedby
	, transfer_route0.label AS transferroute
	, transfer_route0.id AS transferrouteid

from public.transfer_route_point
 LEFT OUTER JOIN public.transfer_route transfer_route0 ON 
 	(public.transfer_route_point.transfer_route_id = 
 	transfer_route0.id)
 ;
	
