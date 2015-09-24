-- SQL Manager 2011 for PostgreSQL 5.0.0.3
-- ---------------------------------------
-- Хост         : 192.168.1.102
-- База данных  : tourism_rcr
-- Версия       : PostgreSQL 9.4beta3 on i686-pc-linux-gnu, compiled by gcc (Ubuntu 4.9.1-16ubuntu6) 4.9.1, 32-bit



SET search_path = public, pg_catalog;
DROP VIEW IF EXISTS public.mail_notebook_view;
DROP VIEW IF EXISTS public.shop_serv_hotel_2_view;
DROP VIEW IF EXISTS public.static_geo_location_view;
DROP VIEW IF EXISTS public.shop_hotel_room_images_view;
DROP VIEW IF EXISTS public.shop_hotel_images_view;
DROP VIEW IF EXISTS public.serv_hotel_simple_view;
DROP VIEW IF EXISTS public.shop_room_view;
DROP VIEW IF EXISTS public.shop_room_tarriff_general_rate_view;
DROP VIEW IF EXISTS public.shop_room_tarriff_original_rate_view;
DROP VIEW IF EXISTS public.shop_room_tarriff_corporate_rate_view;
DROP VIEW IF EXISTS public.req_serv_hotel_processed_view;
DROP VIEW IF EXISTS public.req_serv_hotel_open_view;
DROP VIEW IF EXISTS public.req_serv_hotel_archived_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_room_image_simple_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_image_simple_view;
DROP VIEW IF EXISTS public.payment_tariff_shop_simple_view;
DROP VIEW IF EXISTS public.payment_tariff_simple_view;
DROP VIEW IF EXISTS public.payment_price_shop_simple_view;
DROP VIEW IF EXISTS public.payment_price_simple_view;
DROP VIEW IF EXISTS public.user_registration_request_view;
DROP VIEW IF EXISTS public.users_view;
DROP VIEW IF EXISTS public.user_roles_view;
DROP VIEW IF EXISTS public.user_detail_view;
DROP VIEW IF EXISTS public.tm_user_info_view;
DROP VIEW IF EXISTS public.tm_mail_newsletter_group_view;
DROP VIEW IF EXISTS public.tm_mail_newsletter_view;
DROP VIEW IF EXISTS public.tm_image_view;
DROP VIEW IF EXISTS public.tm_firm_settings_view;
DROP VIEW IF EXISTS public.tm_firms_view;
DROP VIEW IF EXISTS public.tm_contact_easy_view;
DROP VIEW IF EXISTS public.tm_contact_view;
DROP VIEW IF EXISTS public.tm_account_view;
DROP VIEW IF EXISTS public.shop_user_view;
DROP VIEW IF EXISTS public.shop_permission_view;
DROP VIEW IF EXISTS public.serv_transfer_route_point_view;
DROP VIEW IF EXISTS public.serv_transfer_route_view;
DROP VIEW IF EXISTS public.serv_transfer_view;
DROP VIEW IF EXISTS public.serv_hotel_room_view;
DROP VIEW IF EXISTS public.serv_hotel_view;
DROP VIEW IF EXISTS public.req_serv_hotel_view;
DROP VIEW IF EXISTS public.rel_user_details_view;
DROP VIEW IF EXISTS public.rel_shop_permission_view;
DROP VIEW IF EXISTS public.rel_serv_transfer_tm_contact_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_room_image_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_image_view;
DROP VIEW IF EXISTS public.rel_serv_hotel_doc_documents_view;
DROP VIEW IF EXISTS public.rel_mail_newsletter_group_view;
DROP VIEW IF EXISTS public.payment_tariff_shop_view;
DROP VIEW IF EXISTS public.payment_tariff_view;
DROP VIEW IF EXISTS public.payment_price_shop_view;
DROP VIEW IF EXISTS public.payment_price_view;
DROP VIEW IF EXISTS public.payment_details_view;
DROP VIEW IF EXISTS public.location_countries_view;
DROP VIEW IF EXISTS public.location_cities_view;
DROP VIEW IF EXISTS public.location_address_view;
DROP VIEW IF EXISTS public.info_permission_view;
DROP VIEW IF EXISTS public.info_contact_information_view;
DROP VIEW IF EXISTS public.doc_documents_view;
DROP VIEW IF EXISTS public.dict_global_view;
DROP VIEW IF EXISTS public.curr_currency_view;
DROP VIEW IF EXISTS public.curr_course_view;
DROP SEQUENCE IF EXISTS public.sq_tmmailnewslettergroup;
DROP SEQUENCE IF EXISTS public.sq_tmmailnewsletter;
DROP SEQUENCE IF EXISTS public.sq_relmailnewslettergroup;
DROP TABLE IF EXISTS public.rel_mail_newsletter_group;
DROP TABLE IF EXISTS public.tm_mail_newsletter_group;
DROP TABLE IF EXISTS public.tm_mail_newsletter;
DROP SEQUENCE IF EXISTS public.sq_userdetail;
DROP SEQUENCE IF EXISTS public.sq_reluserdetails;
DROP TABLE IF EXISTS public.rel_user_details;
DROP TABLE IF EXISTS public.user_detail;
DROP SEQUENCE IF EXISTS public.sq_shopuser;
DROP SEQUENCE IF EXISTS public.sq_shoppermission;
DROP SEQUENCE IF EXISTS public.sq_relshoppermission;
DROP SEQUENCE IF EXISTS public.sq_infopermission;
DROP TABLE IF EXISTS public.rel_shop_permission;
DROP TABLE IF EXISTS public.info_permission;
DROP TABLE IF EXISTS public.shop_permission;
DROP TABLE IF EXISTS public.shop_user;
DROP VIEW IF EXISTS public.timeline_view;
DROP SEQUENCE IF EXISTS public.sq_paymentpriceshop;
DROP TABLE IF EXISTS public.payment_price_shop;
DROP SEQUENCE IF EXISTS public.sq_paymenttariffshop;
DROP TABLE IF EXISTS public.payment_tariff_shop;
DROP SEQUENCE IF EXISTS public.sq_tmfirmsettings;
DROP TABLE IF EXISTS public.tm_firm_settings;
DROP SEQUENCE IF EXISTS public.sq_users;
DROP SEQUENCE IF EXISTS public.sq_userroles;
DROP SEQUENCE IF EXISTS public.sq_tmuserinfo;
DROP SEQUENCE IF EXISTS public.sq_tmimage;
DROP SEQUENCE IF EXISTS public.sq_tmfirms;
DROP SEQUENCE IF EXISTS public.sq_tmcontacteasy;
DROP SEQUENCE IF EXISTS public.sq_tmcontact;
DROP SEQUENCE IF EXISTS public.sq_tmaccount;
DROP SEQUENCE IF EXISTS public.sq_servtransferroutepoint;
DROP SEQUENCE IF EXISTS public.sq_servtransferroute;
DROP SEQUENCE IF EXISTS public.sq_servtransfer;
DROP SEQUENCE IF EXISTS public.sq_servhotelroom;
DROP SEQUENCE IF EXISTS public.sq_servhotel;
DROP SEQUENCE IF EXISTS public.sq_reqservhotel;
DROP SEQUENCE IF EXISTS public.sq_relservtransfertmcontact;
DROP SEQUENCE IF EXISTS public.sq_relservhotelroomimage;
DROP SEQUENCE IF EXISTS public.sq_relservhotelimage;
DROP SEQUENCE IF EXISTS public.sq_relservhoteldocdocuments;
DROP SEQUENCE IF EXISTS public.sq_relreqservhoteltmcontacteasy;
DROP SEQUENCE IF EXISTS public.sq_paymenttariff;
DROP SEQUENCE IF EXISTS public.sq_paymentprice;
DROP SEQUENCE IF EXISTS public.sq_paymentdetails;
DROP SEQUENCE IF EXISTS public.sq_locationtypeplacement;
DROP SEQUENCE IF EXISTS public.sq_locationcountries;
DROP SEQUENCE IF EXISTS public.sq_locationcities;
DROP SEQUENCE IF EXISTS public.sq_locationaddress;
DROP SEQUENCE IF EXISTS public.sq_infocontactinformation;
DROP SEQUENCE IF EXISTS public.sq_docdocuments;
DROP SEQUENCE IF EXISTS public.sq_dictglobal;
DROP SEQUENCE IF EXISTS public.sq_currcurrency;
DROP SEQUENCE IF EXISTS public.sq_currcourse;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.user_roles;
DROP TABLE IF EXISTS public.tm_user_info;
DROP TABLE IF EXISTS public.tm_image;
DROP TABLE IF EXISTS public.tm_firms;
DROP TABLE IF EXISTS public.tm_contact_easy;
DROP TABLE IF EXISTS public.tm_contact;
DROP TABLE IF EXISTS public.tm_account;
DROP TABLE IF EXISTS public.serv_transfer_route_point;
DROP TABLE IF EXISTS public.serv_transfer_route;
DROP TABLE IF EXISTS public.serv_transfer;
DROP TABLE IF EXISTS public.serv_hotel_room;
DROP TABLE IF EXISTS public.serv_hotel;
DROP TABLE IF EXISTS public.req_serv_hotel;
DROP TABLE IF EXISTS public.rel_serv_transfer_tm_contact;
DROP TABLE IF EXISTS public.rel_serv_hotel_room_image;
DROP TABLE IF EXISTS public.rel_serv_hotel_image;
DROP TABLE IF EXISTS public.rel_serv_hotel_doc_documents;
DROP TABLE IF EXISTS public.payment_tariff;
DROP TABLE IF EXISTS public.payment_price;
DROP TABLE IF EXISTS public.payment_details;
DROP TABLE IF EXISTS public.location_countries;
DROP TABLE IF EXISTS public.location_cities;
DROP TABLE IF EXISTS public.location_address;
DROP TABLE IF EXISTS public.info_contact_information;
DROP TABLE IF EXISTS public.doc_documents;
DROP TABLE IF EXISTS public.dict_global;
DROP TABLE IF EXISTS public.curr_currency;
DROP TABLE IF EXISTS public.curr_course;
SET check_function_bodies = false;
--
-- Structure for table curr_course (OID = 78207) : 
--
CREATE TABLE public.curr_course (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    course integer,
    currencyid integer,
    datecourse timestamp without time zone,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table curr_currency (OID = 78213) : 
--
CREATE TABLE public.curr_currency (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    course integer,
    currencyname varchar(255),
    descr varchar(2000),
    isbase boolean,
    iso_code varchar(255),
    nameeng varchar(255),
    nameru varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table dict_global (OID = 78219) : 
--
CREATE TABLE public.dict_global (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    dict_type varchar(255),
    dict_value varchar(255),
    dict_value_additional varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table doc_documents (OID = 78225) : 
--
CREATE TABLE public.doc_documents (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    contenttype varchar(255),
    extension varchar(255),
    originalfilename varchar(255),
    path varchar(255),
    simpletype varchar(255),
    size varchar(255),
    synopsis varchar(500),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table info_contact_information (OID = 78231) : 
--
CREATE TABLE public.info_contact_information (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    contact varchar(255),
    descr varchar(2000),
    email varchar(255),
    email2 varchar(255),
    email3 varchar(255),
    phone varchar(255),
    phone2 varchar(255),
    phone3 varchar(255),
    website varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table location_address (OID = 78237) : 
--
CREATE TABLE public.location_address (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    descr varchar(2000),
    name varchar(255),
    yandex_map_point_x varchar(255),
    yandex_map_point_y varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table location_cities (OID = 78243) : 
--
CREATE TABLE public.location_cities (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    cityname varchar(255),
    descr varchar(2000),
    countryid integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table location_countries (OID = 78249) : 
--
CREATE TABLE public.location_countries (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    countryname varchar(255),
    descr varchar(2000),
    iso_code varchar(255),
    nameeng varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table payment_details (OID = 78255) : 
--
CREATE TABLE public.payment_details (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    bank_location varchar(255),
    bin varchar(255),
    correspondent_account varchar(255),
    current_account varchar(255),
    full_name varchar(255),
    iin varchar(255),
    legal_address varchar(255),
    name_of_the_bank varchar(255),
    nceo varchar(255),
    phone varchar(255),
    phone2 varchar(255),
    postal_address varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table payment_price (OID = 78261) : 
--
CREATE TABLE public.payment_price (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    humannumber integer,
    price numeric,
    payment_tariff_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table payment_tariff (OID = 78267) : 
--
CREATE TABLE public.payment_tariff (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table rel_serv_hotel_doc_documents (OID = 78273) : 
--
CREATE TABLE public.rel_serv_hotel_doc_documents (
    id integer NOT NULL,
    doc_documents_id integer,
    serv_hotel_id integer
) WITHOUT OIDS;
--
-- Structure for table rel_serv_hotel_image (OID = 78276) : 
--
CREATE TABLE public.rel_serv_hotel_image (
    id integer NOT NULL,
    serv_hotel_id integer,
    image_id integer
) WITHOUT OIDS;
--
-- Structure for table rel_serv_hotel_room_image (OID = 78279) : 
--
CREATE TABLE public.rel_serv_hotel_room_image (
    id integer NOT NULL,
    serv_hotel_room_id integer,
    image_id integer
) WITHOUT OIDS;
--
-- Structure for table rel_serv_transfer_tm_contact (OID = 78282) : 
--
CREATE TABLE public.rel_serv_transfer_tm_contact (
    id integer NOT NULL,
    serv_transfers_id integer,
    tm_contact_id integer
) WITHOUT OIDS;
--
-- Structure for table req_serv_hotel (OID = 78285) : 
--
CREATE TABLE public.req_serv_hotel (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    accept boolean,
    datedifference varchar(255),
    decline boolean,
    departure timestamp without time zone,
    descr varchar(2000),
    payment_type boolean,
    price numeric(17,3),
    progress integer,
    race timestamp without time zone,
    room_count integer,
    singleprice integer,
    tariffcurrency varchar(255),
    document_for_hotel_id integer,
    document_for_user_id integer,
    payment_price_id integer,
    payment_tariff_id integer,
    serv_hotel_id integer,
    serv_hotel_room_id integer,
    request_user_id integer,
    response_user_id integer,
    request_number varchar,
    cancel boolean,
    confirm boolean,
    archived boolean,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table serv_hotel (OID = 78291) : 
--
CREATE TABLE public.serv_hotel (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    blacklist boolean,
    condition_text varchar(2000),
    descr varchar(2000),
    descr_internal varchar(2000),
    favorite boolean,
    freesale boolean,
    problem boolean,
    showonline boolean,
    starcount integer,
    synopsis varchar(500),
    timedeparture varchar(255),
    timeearlyrace varchar(255),
    timelatedeparture varchar(255),
    timerace varchar(255),
    whereroomsarebooked varchar(255),
    contactinformation_id integer,
    address_id integer,
    locationcities_id integer,
    locationcountries_id integer,
    payment_details_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table serv_hotel_room (OID = 78297) : 
--
CREATE TABLE public.serv_hotel_room (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    breakfast boolean,
    descr varchar(2000),
    guest_number integer,
    room_number integer,
    room_type_id integer,
    hotel_id integer,
    shop_tarriff_id integer,
    cost_tarriff_id integer,
    dinner boolean,
    lunch boolean,
    discount integer,
    is_discount boolean,
    commission integer,
    fresale integer,
    fresale_today integer,
    fresale_enabled boolean,
    fresale_start timestamp without time zone,
    fresale_end timestamp without time zone,
    is_commission boolean,
    rr_tarriff_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table serv_transfer (OID = 78303) : 
--
CREATE TABLE public.serv_transfer (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    date_from timestamp without time zone,
    date_to timestamp without time zone,
    descr varchar(2000),
    passengers_phones varchar(255),
    price numeric(17,3),
    transfer_name varchar(255),
    visit_table varchar(255),
    currency_id integer,
    payment_type_id integer,
    transport_id integer,
    type_transfer_id integer,
    location_cities_id integer,
    location_countries_id integer,
    account_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table serv_transfer_route (OID = 78309) : 
--
CREATE TABLE public.serv_transfer_route (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    descr varchar(2000),
    driver varchar(255),
    driver_phone varchar(255),
    fixed_allowance numeric(17,3),
    free boolean,
    percentage_of_allowances numeric(17,3),
    sum integer,
    currency_id integer,
    serv_transfer_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table serv_transfer_route_point (OID = 78315) : 
--
CREATE TABLE public.serv_transfer_route_point (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    fixed_allowance numeric(17,3),
    free boolean,
    percentage_of_allowances numeric(17,3),
    point_from varchar(255),
    point_to varchar(255),
    start_on timestamp without time zone,
    sum integer,
    transfer_route_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table tm_account (OID = 78321) : 
--
CREATE TABLE public.tm_account (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    account_fullname varchar(255),
    account_name varchar(255),
    descr varchar(2000),
    residency_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table tm_contact (OID = 78327) : 
--
CREATE TABLE public.tm_contact (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    birthday timestamp without time zone,
    contact_name varchar(255),
    contact_patronymic varchar(255),
    contact_surname varchar(255),
    descr varchar(2000),
    passport_end_date timestamp without time zone,
    passport_number varchar(255),
    passport_start_date timestamp without time zone,
    citizenship_id integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table tm_contact_easy (OID = 78333) : 
--
CREATE TABLE public.tm_contact_easy (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    descr varchar(2000),
    email varchar(255),
    man_foman boolean,
    phone varchar(255),
    country_id integer,
    req_serv_hotel_id integer,
    id_card boolean,
    identity_number varchar(255),
    passport boolean,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table tm_firms (OID = 78339) : 
--
CREATE TABLE public.tm_firms (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    accountid integer,
    active varchar(255),
    firm_name varchar(255) NOT NULL,
    lastpay timestamp without time zone,
    mounthcount integer,
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table tm_image (OID = 78345) : 
--
CREATE TABLE public.tm_image (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    contenttype varchar(255),
    extension varchar(255),
    name varchar(255),
    originalfilename varchar(255),
    path varchar(255),
    size varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table tm_user_info (OID = 78351) : 
--
CREATE TABLE public.tm_user_info (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    label varchar(255),
    browser varchar(255),
    browser_version varchar(255),
    last_login timestamp without time zone,
    platform varchar(255),
    platformversion varchar(255),
    proxy_content varchar(255),
    remote_host varchar(255),
    user_agent varchar(255),
    user_ip_address varchar(255),
    username varchar(255),
    popularity integer
) WITHOUT OIDS;
--
-- Structure for table user_roles (OID = 78357) : 
--
CREATE TABLE public.user_roles (
    id integer NOT NULL,
    role varchar(255),
    user_id integer
) WITHOUT OIDS;
--
-- Structure for table users (OID = 78360) : 
--
CREATE TABLE public.users (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    activated boolean,
    activationkey varchar(255),
    email varchar(255),
    enabled boolean,
    firstname varchar(255),
    landingpage varchar(255),
    langkey varchar(255),
    lastname varchar(255),
    password varchar(255),
    username varchar(255) NOT NULL,
    image_id integer,
    token varchar(255),
    phonenumber varchar(255),
    user_color varchar,
    popularity integer,
    shop_user boolean,
    physical_person boolean,
    legal_entity boolean
) WITHOUT OIDS;
--
-- Definition for sequence sq_currcourse (OID = 78366) : 
--
CREATE SEQUENCE public.sq_currcourse
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_currcurrency (OID = 78368) : 
--
CREATE SEQUENCE public.sq_currcurrency
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_dictglobal (OID = 78370) : 
--
CREATE SEQUENCE public.sq_dictglobal
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_docdocuments (OID = 78372) : 
--
CREATE SEQUENCE public.sq_docdocuments
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_infocontactinformation (OID = 78374) : 
--
CREATE SEQUENCE public.sq_infocontactinformation
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_locationaddress (OID = 78376) : 
--
CREATE SEQUENCE public.sq_locationaddress
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_locationcities (OID = 78378) : 
--
CREATE SEQUENCE public.sq_locationcities
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_locationcountries (OID = 78380) : 
--
CREATE SEQUENCE public.sq_locationcountries
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_locationtypeplacement (OID = 78382) : 
--
CREATE SEQUENCE public.sq_locationtypeplacement
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_paymentdetails (OID = 78384) : 
--
CREATE SEQUENCE public.sq_paymentdetails
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_paymentprice (OID = 78386) : 
--
CREATE SEQUENCE public.sq_paymentprice
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_paymenttariff (OID = 78388) : 
--
CREATE SEQUENCE public.sq_paymenttariff
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_relreqservhoteltmcontacteasy (OID = 78390) : 
--
CREATE SEQUENCE public.sq_relreqservhoteltmcontacteasy
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_relservhoteldocdocuments (OID = 78392) : 
--
CREATE SEQUENCE public.sq_relservhoteldocdocuments
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_relservhotelimage (OID = 78394) : 
--
CREATE SEQUENCE public.sq_relservhotelimage
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_relservhotelroomimage (OID = 78396) : 
--
CREATE SEQUENCE public.sq_relservhotelroomimage
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_relservtransfertmcontact (OID = 78398) : 
--
CREATE SEQUENCE public.sq_relservtransfertmcontact
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_reqservhotel (OID = 78400) : 
--
CREATE SEQUENCE public.sq_reqservhotel
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_servhotel (OID = 78402) : 
--
CREATE SEQUENCE public.sq_servhotel
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_servhotelroom (OID = 78404) : 
--
CREATE SEQUENCE public.sq_servhotelroom
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_servtransfer (OID = 78406) : 
--
CREATE SEQUENCE public.sq_servtransfer
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_servtransferroute (OID = 78408) : 
--
CREATE SEQUENCE public.sq_servtransferroute
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_servtransferroutepoint (OID = 78410) : 
--
CREATE SEQUENCE public.sq_servtransferroutepoint
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmaccount (OID = 78412) : 
--
CREATE SEQUENCE public.sq_tmaccount
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmcontact (OID = 78414) : 
--
CREATE SEQUENCE public.sq_tmcontact
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmcontacteasy (OID = 78416) : 
--
CREATE SEQUENCE public.sq_tmcontacteasy
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmfirms (OID = 78418) : 
--
CREATE SEQUENCE public.sq_tmfirms
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmimage (OID = 78420) : 
--
CREATE SEQUENCE public.sq_tmimage
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmuserinfo (OID = 78422) : 
--
CREATE SEQUENCE public.sq_tmuserinfo
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_userroles (OID = 78424) : 
--
CREATE SEQUENCE public.sq_userroles
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_users (OID = 78426) : 
--
CREATE SEQUENCE public.sq_users
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Structure for table tm_firm_settings (OID = 78428) : 
--
CREATE TABLE public.tm_firm_settings (
    id integer NOT NULL,
    logo_id integer,
    brand varchar,
    doc_documents_id integer,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer
) WITHOUT OIDS;
--
-- Definition for sequence sq_tmfirmsettings (OID = 78434) : 
--
CREATE SEQUENCE public.sq_tmfirmsettings
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Structure for table payment_tariff_shop (OID = 78436) : 
--
CREATE TABLE public.payment_tariff_shop (
    id integer NOT NULL,
    percentage_of_allowances integer,
    is_percentage_of_allowances boolean,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer
) WITHOUT OIDS;
--
-- Definition for sequence sq_paymenttariffshop (OID = 78442) : 
--
CREATE SEQUENCE public.sq_paymenttariffshop
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Structure for table payment_price_shop (OID = 78444) : 
--
CREATE TABLE public.payment_price_shop (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    humannumber integer,
    price numeric,
    popularity integer,
    payment_tariff_shop_id integer
) WITHOUT OIDS;
--
-- Definition for sequence sq_paymentpriceshop (OID = 78450) : 
--
CREATE SEQUENCE public.sq_paymentpriceshop
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for view timeline_view (OID = 79446) : 
--
CREATE VIEW public.timeline_view AS
SELECT c0b0a2b34c5tbl.id,
    NULL::text AS label,
    c0b0a2b34c5tbl.firmid,
    c0b0a2b34c5tbl.createon,
    c0b0a2b34c5tbl.modifyon,
    c0b0a2b34c5tbl.createdby,
    c0b0a2b34c5tbl.lastmodifiedby,
    md5(((c0b0a2b34c5tbl.id)::text || 'CurrCourse'::text)) AS hashid,
    'CurrCourse'::text AS module
FROM curr_course c0b0a2b34c5tbl
UNION
SELECT c5c9a9214b8tbl.id,
    NULL::text AS label,
    c5c9a9214b8tbl.firmid,
    c5c9a9214b8tbl.createon,
    c5c9a9214b8tbl.modifyon,
    c5c9a9214b8tbl.createdby,
    c5c9a9214b8tbl.lastmodifiedby,
    md5(((c5c9a9214b8tbl.id)::text || 'CurrCurrency'::text)) AS hashid,
    'CurrCurrency'::text AS module
FROM curr_currency c5c9a9214b8tbl
UNION
SELECT d816e0965e2tbl.id,
    NULL::text AS label,
    d816e0965e2tbl.firmid,
    d816e0965e2tbl.createon,
    d816e0965e2tbl.modifyon,
    d816e0965e2tbl.createdby,
    d816e0965e2tbl.lastmodifiedby,
    md5(((d816e0965e2tbl.id)::text || 'DocDocuments'::text)) AS hashid,
    'DocDocuments'::text AS module
FROM doc_documents d816e0965e2tbl
UNION
SELECT ieec8536989tbl.id,
    NULL::text AS label,
    ieec8536989tbl.firmid,
    ieec8536989tbl.createon,
    ieec8536989tbl.modifyon,
    ieec8536989tbl.createdby,
    ieec8536989tbl.lastmodifiedby,
    md5(((ieec8536989tbl.id)::text || 'InfoContactInformation'::text)) AS hashid,
    'InfoContactInformation'::text AS module
FROM info_contact_information ieec8536989tbl
UNION
SELECT idb18a48b26tbl.id,
    idb18a48b26tbl.label,
    idb18a48b26tbl.firmid,
    idb18a48b26tbl.createon,
    idb18a48b26tbl.modifyon,
    idb18a48b26tbl.createdby,
    idb18a48b26tbl.lastmodifiedby,
    md5(((idb18a48b26tbl.id)::text || 'InfoPermission'::text)) AS hashid,
    'InfoPermission'::text AS module
FROM info_permission idb18a48b26tbl
UNION
SELECT l64192fd4cbtbl.id,
    l64192fd4cbtbl.label,
    l64192fd4cbtbl.firmid,
    l64192fd4cbtbl.createon,
    l64192fd4cbtbl.modifyon,
    l64192fd4cbtbl.createdby,
    l64192fd4cbtbl.lastmodifiedby,
    md5(((l64192fd4cbtbl.id)::text || 'LocationAddress'::text)) AS hashid,
    'LocationAddress'::text AS module
FROM location_address l64192fd4cbtbl
UNION
SELECT l846ace6749tbl.id,
    l846ace6749tbl.cityname AS label,
    l846ace6749tbl.firmid,
    l846ace6749tbl.createon,
    l846ace6749tbl.modifyon,
    l846ace6749tbl.createdby,
    l846ace6749tbl.lastmodifiedby,
    md5(((l846ace6749tbl.id)::text || 'LocationCities'::text)) AS hashid,
    'LocationCities'::text AS module
FROM location_cities l846ace6749tbl
UNION
SELECT lc32d4253e7tbl.id,
    lc32d4253e7tbl.countryname AS label,
    lc32d4253e7tbl.firmid,
    lc32d4253e7tbl.createon,
    lc32d4253e7tbl.modifyon,
    lc32d4253e7tbl.createdby,
    lc32d4253e7tbl.lastmodifiedby,
    md5(((lc32d4253e7tbl.id)::text || 'LocationCountries'::text)) AS hashid,
    'LocationCountries'::text AS module
FROM location_countries lc32d4253e7tbl
UNION
SELECT p1c40abc625tbl.id,
    NULL::text AS label,
    p1c40abc625tbl.firmid,
    p1c40abc625tbl.createon,
    p1c40abc625tbl.modifyon,
    p1c40abc625tbl.createdby,
    p1c40abc625tbl.lastmodifiedby,
    md5(((p1c40abc625tbl.id)::text || 'PaymentDetails'::text)) AS hashid,
    'PaymentDetails'::text AS module
FROM payment_details p1c40abc625tbl
UNION
SELECT pf14c53cfbbtbl.id,
    NULL::text AS label,
    pf14c53cfbbtbl.firmid,
    pf14c53cfbbtbl.createon,
    pf14c53cfbbtbl.modifyon,
    pf14c53cfbbtbl.createdby,
    pf14c53cfbbtbl.lastmodifiedby,
    md5(((pf14c53cfbbtbl.id)::text || 'PaymentPrice'::text)) AS hashid,
    'PaymentPrice'::text AS module
FROM payment_price pf14c53cfbbtbl
UNION
SELECT pc2e897ad70tbl.id,
    NULL::text AS label,
    pc2e897ad70tbl.firmid,
    pc2e897ad70tbl.createon,
    pc2e897ad70tbl.modifyon,
    pc2e897ad70tbl.createdby,
    pc2e897ad70tbl.lastmodifiedby,
    md5(((pc2e897ad70tbl.id)::text || 'PaymentPriceShop'::text)) AS hashid,
    'PaymentPriceShop'::text AS module
FROM payment_price_shop pc2e897ad70tbl
UNION
SELECT pd6c3ae051btbl.id,
    NULL::text AS label,
    pd6c3ae051btbl.firmid,
    pd6c3ae051btbl.createon,
    pd6c3ae051btbl.modifyon,
    pd6c3ae051btbl.createdby,
    pd6c3ae051btbl.lastmodifiedby,
    md5(((pd6c3ae051btbl.id)::text || 'PaymentTariff'::text)) AS hashid,
    'PaymentTariff'::text AS module
FROM payment_tariff pd6c3ae051btbl
UNION
SELECT pbdd1628be2tbl.id,
    NULL::text AS label,
    pbdd1628be2tbl.firmid,
    pbdd1628be2tbl.createon,
    pbdd1628be2tbl.modifyon,
    pbdd1628be2tbl.createdby,
    pbdd1628be2tbl.lastmodifiedby,
    md5(((pbdd1628be2tbl.id)::text || 'PaymentTariffShop'::text)) AS hashid,
    'PaymentTariffShop'::text AS module
FROM payment_tariff_shop pbdd1628be2tbl
UNION
SELECT r2676253d98tbl.id,
    r2676253d98tbl.label,
    r2676253d98tbl.firmid,
    r2676253d98tbl.createon,
    r2676253d98tbl.modifyon,
    r2676253d98tbl.createdby,
    r2676253d98tbl.lastmodifiedby,
    md5(((r2676253d98tbl.id)::text || 'ReqServHotel'::text)) AS hashid,
    'ReqServHotel'::text AS module
FROM req_serv_hotel r2676253d98tbl
UNION
SELECT sb8c6e89a24tbl.id,
    sb8c6e89a24tbl.label,
    sb8c6e89a24tbl.firmid,
    sb8c6e89a24tbl.createon,
    sb8c6e89a24tbl.modifyon,
    sb8c6e89a24tbl.createdby,
    sb8c6e89a24tbl.lastmodifiedby,
    md5(((sb8c6e89a24tbl.id)::text || 'ServHotel'::text)) AS hashid,
    'ServHotel'::text AS module
FROM serv_hotel sb8c6e89a24tbl
UNION
SELECT s8e9c94f452tbl.id,
    s8e9c94f452tbl.label,
    s8e9c94f452tbl.firmid,
    s8e9c94f452tbl.createon,
    s8e9c94f452tbl.modifyon,
    s8e9c94f452tbl.createdby,
    s8e9c94f452tbl.lastmodifiedby,
    md5(((s8e9c94f452tbl.id)::text || 'ServHotelRoom'::text)) AS hashid,
    'ServHotelRoom'::text AS module
FROM serv_hotel_room s8e9c94f452tbl
UNION
SELECT s204467bce8tbl.id,
    s204467bce8tbl.label,
    s204467bce8tbl.firmid,
    s204467bce8tbl.createon,
    s204467bce8tbl.modifyon,
    s204467bce8tbl.createdby,
    s204467bce8tbl.lastmodifiedby,
    md5(((s204467bce8tbl.id)::text || 'ServTransfer'::text)) AS hashid,
    'ServTransfer'::text AS module
FROM serv_transfer s204467bce8tbl
UNION
SELECT se7fd9aed6dtbl.id,
    se7fd9aed6dtbl.label,
    se7fd9aed6dtbl.firmid,
    se7fd9aed6dtbl.createon,
    se7fd9aed6dtbl.modifyon,
    se7fd9aed6dtbl.createdby,
    se7fd9aed6dtbl.lastmodifiedby,
    md5(((se7fd9aed6dtbl.id)::text || 'ServTransferRoute'::text)) AS hashid,
    'ServTransferRoute'::text AS module
FROM serv_transfer_route se7fd9aed6dtbl
UNION
SELECT s484716fad7tbl.id,
    s484716fad7tbl.label,
    s484716fad7tbl.firmid,
    s484716fad7tbl.createon,
    s484716fad7tbl.modifyon,
    s484716fad7tbl.createdby,
    s484716fad7tbl.lastmodifiedby,
    md5(((s484716fad7tbl.id)::text || 'ServTransferRoutePoint'::text)) AS hashid,
    'ServTransferRoutePoint'::text AS module
FROM serv_transfer_route_point s484716fad7tbl
UNION
SELECT s181e6afb9etbl.id,
    s181e6afb9etbl.label,
    s181e6afb9etbl.firmid,
    s181e6afb9etbl.createon,
    s181e6afb9etbl.modifyon,
    s181e6afb9etbl.createdby,
    s181e6afb9etbl.lastmodifiedby,
    md5(((s181e6afb9etbl.id)::text || 'ShopPermission'::text)) AS hashid,
    'ShopPermission'::text AS module
FROM shop_permission s181e6afb9etbl
UNION
SELECT s0dbabdc917tbl.id,
    s0dbabdc917tbl.label,
    s0dbabdc917tbl.firmid,
    s0dbabdc917tbl.createon,
    s0dbabdc917tbl.modifyon,
    s0dbabdc917tbl.createdby,
    s0dbabdc917tbl.lastmodifiedby,
    md5(((s0dbabdc917tbl.id)::text || 'ShopUser'::text)) AS hashid,
    'ShopUser'::text AS module
FROM shop_user s0dbabdc917tbl
UNION
SELECT tb34a44a279tbl.id,
    tb34a44a279tbl.account_name AS label,
    tb34a44a279tbl.firmid,
    tb34a44a279tbl.createon,
    tb34a44a279tbl.modifyon,
    tb34a44a279tbl.createdby,
    tb34a44a279tbl.lastmodifiedby,
    md5(((tb34a44a279tbl.id)::text || 'TmAccount'::text)) AS hashid,
    'TmAccount'::text AS module
FROM tm_account tb34a44a279tbl
UNION
SELECT tf95cef3041tbl.id,
    (((((tf95cef3041tbl.contact_surname)::text || ' '::text) ||
        (tf95cef3041tbl.contact_name)::text) || ' '::text) ||
        (tf95cef3041tbl.contact_patronymic)::text) AS label,
    tf95cef3041tbl.firmid,
    tf95cef3041tbl.createon,
    tf95cef3041tbl.modifyon,
    tf95cef3041tbl.createdby,
    tf95cef3041tbl.lastmodifiedby,
    md5(((tf95cef3041tbl.id)::text || 'TmContact'::text)) AS hashid,
    'TmContact'::text AS module
FROM tm_contact tf95cef3041tbl
UNION
SELECT tc000aa142ctbl.id,
    tc000aa142ctbl.label,
    tc000aa142ctbl.firmid,
    tc000aa142ctbl.createon,
    tc000aa142ctbl.modifyon,
    tc000aa142ctbl.createdby,
    tc000aa142ctbl.lastmodifiedby,
    md5(((tc000aa142ctbl.id)::text || 'TmContactEasy'::text)) AS hashid,
    'TmContactEasy'::text AS module
FROM tm_contact_easy tc000aa142ctbl
UNION
SELECT t8d91b8a171tbl.id,
    t8d91b8a171tbl.label,
    t8d91b8a171tbl.firmid,
    t8d91b8a171tbl.createon,
    t8d91b8a171tbl.modifyon,
    t8d91b8a171tbl.createdby,
    t8d91b8a171tbl.lastmodifiedby,
    md5(((t8d91b8a171tbl.id)::text || 'TmFirms'::text)) AS hashid,
    'TmFirms'::text AS module
FROM tm_firms t8d91b8a171tbl
UNION
SELECT t5869d1f81ftbl.id,
    NULL::text AS label,
    t5869d1f81ftbl.firmid,
    t5869d1f81ftbl.createon,
    t5869d1f81ftbl.modifyon,
    t5869d1f81ftbl.createdby,
    t5869d1f81ftbl.lastmodifiedby,
    md5(((t5869d1f81ftbl.id)::text || 'TmFirmSettings'::text)) AS hashid,
    'TmFirmSettings'::text AS module
FROM tm_firm_settings t5869d1f81ftbl
UNION
SELECT tc13ac3749atbl.id,
    NULL::text AS label,
    tc13ac3749atbl.firmid,
    tc13ac3749atbl.createon,
    tc13ac3749atbl.modifyon,
    tc13ac3749atbl.createdby,
    tc13ac3749atbl.lastmodifiedby,
    md5(((tc13ac3749atbl.id)::text || 'TmImage'::text)) AS hashid,
    'TmImage'::text AS module
FROM tm_image tc13ac3749atbl
UNION
SELECT t05a18e3900tbl.id,
    t05a18e3900tbl.label,
    t05a18e3900tbl.firmid,
    t05a18e3900tbl.createon,
    t05a18e3900tbl.modifyon,
    t05a18e3900tbl.createdby,
    t05a18e3900tbl.lastmodifiedby,
    md5(((t05a18e3900tbl.id)::text || 'TmMailNewsletter'::text)) AS hashid,
    'TmMailNewsletter'::text AS module
FROM tm_mail_newsletter t05a18e3900tbl
UNION
SELECT t0f93470591tbl.id,
    t0f93470591tbl.label,
    t0f93470591tbl.firmid,
    t0f93470591tbl.createon,
    t0f93470591tbl.modifyon,
    t0f93470591tbl.createdby,
    t0f93470591tbl.lastmodifiedby,
    md5(((t0f93470591tbl.id)::text || 'TmMailNewsletterGroup'::text)) AS hashid,
    'TmMailNewsletterGroup'::text AS module
FROM tm_mail_newsletter_group t0f93470591tbl
UNION
SELECT uaa8124f6dftbl.id,
    uaa8124f6dftbl.label,
    uaa8124f6dftbl.firmid,
    uaa8124f6dftbl.createon,
    uaa8124f6dftbl.modifyon,
    uaa8124f6dftbl.createdby,
    uaa8124f6dftbl.lastmodifiedby,
    md5(((uaa8124f6dftbl.id)::text || 'UserDetail'::text)) AS hashid,
    'UserDetail'::text AS module
FROM user_detail uaa8124f6dftbl
UNION
SELECT ucd4d2c916btbl.id,
    NULL::text AS label,
    ucd4d2c916btbl.firmid,
    ucd4d2c916btbl.createon,
    ucd4d2c916btbl.modifyon,
    ucd4d2c916btbl.createdby,
    ucd4d2c916btbl.lastmodifiedby,
    md5(((ucd4d2c916btbl.id)::text || 'Users'::text)) AS hashid,
    'Users'::text AS module
FROM users ucd4d2c916btbl;

--
-- Structure for table shop_user (OID = 79682) : 
--
CREATE TABLE public.shop_user (
    id integer NOT NULL,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    serieskey varchar(255),
    version integer,
    activated boolean,
    activationkey varchar(255),
    email varchar(255),
    enabled boolean,
    firstname varchar(255),
    lastname varchar(255),
    password varchar(255),
    username varchar(255) NOT NULL,
    image_id integer,
    token varchar(255),
    phonenumber varchar(255),
    popularity integer,
    shop_permission_id integer,
    label varchar(255)
) WITHOUT OIDS;
--
-- Structure for table shop_permission (OID = 79692) : 
--
CREATE TABLE public.shop_permission (
    id integer NOT NULL,
    allocated_firm_id integer,
    physical_person boolean,
    corporate_customer boolean,
    travel_agency boolean,
    travel_operator boolean,
    partner boolean,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer,
    label varchar(255)
) WITHOUT OIDS;
--
-- Structure for table info_permission (OID = 79697) : 
--
CREATE TABLE public.info_permission (
    id integer NOT NULL,
    descr varchar,
    doc_document_id integer,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer,
    label varchar(255)
) WITHOUT OIDS;
--
-- Structure for table rel_shop_permission (OID = 79705) : 
--
CREATE TABLE public.rel_shop_permission (
    id integer NOT NULL,
    shop_permission_id integer,
    info_permission_id integer
) WITHOUT OIDS;
--
-- Definition for sequence sq_infopermission (OID = 80299) : 
--
CREATE SEQUENCE public.sq_infopermission
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_relshoppermission (OID = 80301) : 
--
CREATE SEQUENCE public.sq_relshoppermission
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_shoppermission (OID = 80303) : 
--
CREATE SEQUENCE public.sq_shoppermission
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_shopuser (OID = 80305) : 
--
CREATE SEQUENCE public.sq_shopuser
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Structure for table user_detail (OID = 80307) : 
--
CREATE TABLE public.user_detail (
    id integer NOT NULL,
    company_name varchar,
    company_site varchar,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer,
    label varchar(255)
) WITHOUT OIDS;
--
-- Structure for table rel_user_details (OID = 80315) : 
--
CREATE TABLE public.rel_user_details (
    id integer NOT NULL,
    user_details_id integer,
    users_id integer
) WITHOUT OIDS;
--
-- Definition for sequence sq_reluserdetails (OID = 80413) : 
--
CREATE SEQUENCE public.sq_reluserdetails
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_userdetail (OID = 80415) : 
--
CREATE SEQUENCE public.sq_userdetail
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Structure for table tm_mail_newsletter (OID = 80945) : 
--
CREATE TABLE public.tm_mail_newsletter (
    id integer NOT NULL,
    subject varchar,
    content varchar,
    background_color varchar,
    badge varchar,
    badge_type varchar,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer,
    label varchar(255)
) WITHOUT OIDS;
--
-- Structure for table tm_mail_newsletter_group (OID = 80953) : 
--
CREATE TABLE public.tm_mail_newsletter_group (
    id integer NOT NULL,
    email varchar,
    name varchar,
    createdby varchar(255),
    createon timestamp without time zone,
    firmid integer,
    lastmodifiedby varchar(255),
    modifyon timestamp without time zone,
    popularity integer,
    serieskey varchar(255),
    version integer,
    label varchar(255)
) WITHOUT OIDS;
--
-- Structure for table rel_mail_newsletter_group (OID = 80961) : 
--
CREATE TABLE public.rel_mail_newsletter_group (
    id integer NOT NULL,
    tm_mail_newsletter_id integer,
    tm_mail_newsletter_group_id integer
) WITHOUT OIDS;
--
-- Definition for sequence sq_relmailnewslettergroup (OID = 80976) : 
--
CREATE SEQUENCE public.sq_relmailnewslettergroup
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmmailnewsletter (OID = 80978) : 
--
CREATE SEQUENCE public.sq_tmmailnewsletter
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for sequence sq_tmmailnewslettergroup (OID = 80980) : 
--
CREATE SEQUENCE public.sq_tmmailnewslettergroup
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for view curr_course_view (OID = 80982) : 
--
CREATE VIEW public.curr_course_view AS
SELECT curr_course.id,
    curr_course.version,
    curr_course.createdby,
    curr_course.createon,
    curr_course.firmid AS firm,
    curr_course.lastmodifiedby,
    curr_course.modifyon,
    curr_course.serieskey,
    curr_course.course,
    curr_course.currencyid AS currency,
    curr_course.datecourse,
    curr_course.popularity
FROM curr_course;

--
-- Definition for view curr_currency_view (OID = 80986) : 
--
CREATE VIEW public.curr_currency_view AS
SELECT curr_currency.id,
    curr_currency.version,
    curr_currency.createdby,
    curr_currency.createon,
    curr_currency.firmid AS firm,
    curr_currency.lastmodifiedby,
    curr_currency.modifyon,
    curr_currency.serieskey,
    curr_currency.course,
    curr_currency.currencyname,
    curr_currency.descr,
    curr_currency.isbase,
    curr_currency.iso_code AS isocode,
    curr_currency.nameeng,
    curr_currency.nameru,
    curr_currency.popularity
FROM curr_currency;

--
-- Definition for view dict_global_view (OID = 80990) : 
--
CREATE VIEW public.dict_global_view AS
SELECT dict_global.id,
    dict_global.version,
    dict_global.createdby,
    dict_global.createon,
    dict_global.firmid AS firm,
    dict_global.lastmodifiedby,
    dict_global.modifyon,
    dict_global.serieskey,
    dict_global.dict_type AS dicttype,
    dict_global.dict_value AS dictvalue,
    dict_global.dict_value_additional AS dictvalueadditional,
    dict_global.popularity
FROM dict_global;

--
-- Definition for view doc_documents_view (OID = 80994) : 
--
CREATE VIEW public.doc_documents_view AS
SELECT doc_documents.id,
    doc_documents.version,
    doc_documents.createdby,
    doc_documents.createon,
    doc_documents.firmid AS firm,
    doc_documents.lastmodifiedby,
    doc_documents.modifyon,
    doc_documents.serieskey,
    doc_documents.contenttype,
    doc_documents.extension,
    doc_documents.originalfilename,
    doc_documents.path,
    doc_documents.simpletype,
    doc_documents.size,
    doc_documents.synopsis,
    doc_documents.popularity,
    doc_documents.originalfilename AS label
FROM doc_documents;

--
-- Definition for view info_contact_information_view (OID = 80998) : 
--
CREATE VIEW public.info_contact_information_view AS
SELECT info_contact_information.id,
    info_contact_information.version,
    info_contact_information.createdby,
    info_contact_information.createon,
    info_contact_information.firmid AS firm,
    info_contact_information.lastmodifiedby,
    info_contact_information.modifyon,
    info_contact_information.serieskey,
    info_contact_information.contact,
    info_contact_information.descr,
    info_contact_information.email,
    info_contact_information.email2,
    info_contact_information.email3,
    info_contact_information.phone,
    info_contact_information.phone2,
    info_contact_information.phone3,
    info_contact_information.website,
    info_contact_information.popularity
FROM info_contact_information;

--
-- Definition for view info_permission_view (OID = 81002) : 
--
CREATE VIEW public.info_permission_view AS
SELECT info_permission.id,
    info_permission.version,
    info_permission.descr,
    info_permission.createdby,
    info_permission.createon,
    info_permission.firmid AS firm,
    info_permission.lastmodifiedby,
    info_permission.modifyon,
    info_permission.popularity,
    info_permission.serieskey,
    info_permission.label,
    doc_documents0.originalfilename AS docdocuments,
    doc_documents0.id AS docdocumentsid
FROM (info_permission
     LEFT JOIN doc_documents doc_documents0 ON
         ((info_permission.doc_document_id = doc_documents0.id)));

--
-- Definition for view location_address_view (OID = 81007) : 
--
CREATE VIEW public.location_address_view AS
SELECT location_address.id,
    location_address.version,
    location_address.createdby,
    location_address.createon,
    location_address.firmid AS firm,
    location_address.lastmodifiedby,
    location_address.modifyon,
    location_address.serieskey,
    location_address.label,
    location_address.descr,
    location_address.name,
    location_address.yandex_map_point_x AS yandexmappointx,
    location_address.yandex_map_point_y AS yandexmappointy,
    location_address.popularity
FROM location_address;

--
-- Definition for view location_cities_view (OID = 81011) : 
--
CREATE VIEW public.location_cities_view AS
SELECT location_cities.id,
    location_cities.version,
    location_cities.createdby,
    location_cities.createon,
    location_cities.firmid AS firm,
    location_cities.lastmodifiedby,
    location_cities.modifyon,
    location_cities.serieskey,
    location_cities.cityname,
    location_cities.descr,
    location_cities.popularity,
    location_countries0.countryname AS locationcountries,
    location_countries0.id AS locationcountriesid
FROM (location_cities
     LEFT JOIN location_countries location_countries0 ON
         ((location_cities.countryid = location_countries0.id)));

--
-- Definition for view location_countries_view (OID = 81015) : 
--
CREATE VIEW public.location_countries_view AS
SELECT location_countries.id,
    location_countries.version,
    location_countries.createdby,
    location_countries.createon,
    location_countries.firmid AS firm,
    location_countries.lastmodifiedby,
    location_countries.modifyon,
    location_countries.serieskey,
    location_countries.countryname,
    location_countries.descr,
    location_countries.iso_code AS isocode,
    location_countries.nameeng,
    location_countries.popularity
FROM location_countries;

--
-- Definition for view payment_details_view (OID = 81019) : 
--
CREATE VIEW public.payment_details_view AS
SELECT payment_details.id,
    payment_details.version,
    payment_details.createdby,
    payment_details.createon,
    payment_details.firmid AS firm,
    payment_details.lastmodifiedby,
    payment_details.modifyon,
    payment_details.serieskey,
    payment_details.bank_location AS banklocation,
    payment_details.bin,
    payment_details.correspondent_account AS correspondentaccount,
    payment_details.current_account AS currentaccount,
    payment_details.full_name AS fullname,
    payment_details.iin,
    payment_details.legal_address AS legaladdress,
    payment_details.name_of_the_bank AS nameofthebank,
    payment_details.nceo,
    payment_details.phone,
    payment_details.phone2,
    payment_details.postal_address AS postaladdress,
    payment_details.popularity
FROM payment_details;

--
-- Definition for view payment_price_view (OID = 81023) : 
--
CREATE VIEW public.payment_price_view AS
SELECT payment_price.id,
    payment_price.version,
    payment_price.createdby,
    payment_price.createon,
    payment_price.firmid AS firm,
    payment_price.lastmodifiedby,
    payment_price.modifyon,
    payment_price.serieskey,
    payment_price.humannumber,
    payment_price.price,
    payment_price.popularity,
    ''::text AS paymenttariff,
    payment_tariff0.id AS paymenttariffid
FROM (payment_price
     LEFT JOIN payment_tariff payment_tariff0 ON
         ((payment_price.payment_tariff_id = payment_tariff0.id)));

--
-- Definition for view payment_price_shop_view (OID = 81027) : 
--
CREATE VIEW public.payment_price_shop_view AS
SELECT payment_price_shop.id,
    payment_price_shop.version,
    payment_price_shop.createdby,
    payment_price_shop.createon,
    payment_price_shop.firmid AS firm,
    payment_price_shop.lastmodifiedby,
    payment_price_shop.modifyon,
    payment_price_shop.serieskey,
    payment_price_shop.humannumber,
    payment_price_shop.price,
    payment_price_shop.popularity,
    ''::text AS paymenttariffshop,
    payment_tariff_shop0.id AS paymenttariffshopid
FROM (payment_price_shop
     LEFT JOIN payment_tariff_shop payment_tariff_shop0 ON
         ((payment_price_shop.payment_tariff_shop_id = payment_tariff_shop0.id)));

--
-- Definition for view payment_tariff_view (OID = 81032) : 
--
CREATE VIEW public.payment_tariff_view AS
SELECT payment_tariff.id,
    payment_tariff.version,
    payment_tariff.createdby,
    payment_tariff.createon,
    payment_tariff.firmid AS firm,
    payment_tariff.lastmodifiedby,
    payment_tariff.modifyon,
    payment_tariff.serieskey,
    payment_tariff.popularity
FROM payment_tariff;

--
-- Definition for view payment_tariff_shop_view (OID = 81036) : 
--
CREATE VIEW public.payment_tariff_shop_view AS
SELECT payment_tariff_shop.id,
    payment_tariff_shop.version,
    payment_tariff_shop.percentage_of_allowances AS percentageofallowances,
    payment_tariff_shop.is_percentage_of_allowances AS ispercentageofallowances,
    payment_tariff_shop.createdby,
    payment_tariff_shop.createon,
    payment_tariff_shop.firmid AS firm,
    payment_tariff_shop.lastmodifiedby,
    payment_tariff_shop.modifyon,
    payment_tariff_shop.popularity,
    payment_tariff_shop.serieskey
FROM payment_tariff_shop;

--
-- Definition for view rel_mail_newsletter_group_view (OID = 81040) : 
--
CREATE VIEW public.rel_mail_newsletter_group_view AS
SELECT rel_mail_newsletter_group.id,
    tm_mail_newsletter0.label AS tmmailnewsletter,
    tm_mail_newsletter0.id AS tmmailnewsletterid,
    tm_mail_newsletter_group1.label AS tmmailnewslettergroup,
    tm_mail_newsletter_group1.id AS tmmailnewslettergroupid
FROM ((rel_mail_newsletter_group
     LEFT JOIN tm_mail_newsletter tm_mail_newsletter0 ON
         ((rel_mail_newsletter_group.tm_mail_newsletter_id =
         tm_mail_newsletter0.id)))
     LEFT JOIN tm_mail_newsletter_group tm_mail_newsletter_group1 ON
         ((rel_mail_newsletter_group.tm_mail_newsletter_group_id =
         tm_mail_newsletter_group1.id)));

--
-- Definition for view rel_serv_hotel_doc_documents_view (OID = 81045) : 
--
CREATE VIEW public.rel_serv_hotel_doc_documents_view AS
SELECT rel_serv_hotel_doc_documents.id,
    doc_documents0.originalfilename AS docdocuments,
    doc_documents0.id AS docdocumentsid,
    serv_hotel1.label AS servhotel,
    serv_hotel1.id AS servhotelid
FROM ((rel_serv_hotel_doc_documents
     LEFT JOIN doc_documents doc_documents0 ON
         ((rel_serv_hotel_doc_documents.doc_documents_id = doc_documents0.id)))
     LEFT JOIN serv_hotel serv_hotel1 ON
         ((rel_serv_hotel_doc_documents.serv_hotel_id = serv_hotel1.id)));

--
-- Definition for view rel_serv_hotel_image_view (OID = 81050) : 
--
CREATE VIEW public.rel_serv_hotel_image_view AS
SELECT rel_serv_hotel_image.id,
    serv_hotel0.label AS servhotel,
    serv_hotel0.id AS servhotelid,
    (((tm_image1.name)::text || '.'::text) || (tm_image1.extension)::text)
        AS tmimage,
    tm_image1.id AS tmimageid
FROM ((rel_serv_hotel_image
     LEFT JOIN serv_hotel serv_hotel0 ON
         ((rel_serv_hotel_image.serv_hotel_id = serv_hotel0.id)))
     LEFT JOIN tm_image tm_image1 ON ((rel_serv_hotel_image.image_id =
         tm_image1.id)));

--
-- Definition for view rel_serv_hotel_room_image_view (OID = 81055) : 
--
CREATE VIEW public.rel_serv_hotel_room_image_view AS
SELECT rel_serv_hotel_room_image.id,
    serv_hotel_room0.label AS servhotelroom,
    serv_hotel_room0.id AS servhotelroomid,
    (((tm_image1.name)::text || '.'::text) || (tm_image1.extension)::text)
        AS tmimage,
    tm_image1.id AS tmimageid
FROM ((rel_serv_hotel_room_image
     LEFT JOIN serv_hotel_room serv_hotel_room0 ON
         ((rel_serv_hotel_room_image.serv_hotel_room_id = serv_hotel_room0.id)))
     LEFT JOIN tm_image tm_image1 ON ((rel_serv_hotel_room_image.image_id =
         tm_image1.id)));

--
-- Definition for view rel_serv_transfer_tm_contact_view (OID = 81060) : 
--
CREATE VIEW public.rel_serv_transfer_tm_contact_view AS
SELECT rel_serv_transfer_tm_contact.id,
    serv_transfer0.label AS servtransfer,
    serv_transfer0.id AS servtransferid,
    (((tm_contact1.contact_surname)::text || ' '::text) ||
        (tm_contact1.contact_name)::text) AS tmcontact,
    tm_contact1.id AS tmcontactid
FROM ((rel_serv_transfer_tm_contact
     LEFT JOIN serv_transfer serv_transfer0 ON
         ((rel_serv_transfer_tm_contact.serv_transfers_id = serv_transfer0.id)))
     LEFT JOIN tm_contact tm_contact1 ON
         ((rel_serv_transfer_tm_contact.tm_contact_id = tm_contact1.id)));

--
-- Definition for view rel_shop_permission_view (OID = 81065) : 
--
CREATE VIEW public.rel_shop_permission_view AS
SELECT rel_shop_permission.id,
    info_permission0.label AS infopermission,
    info_permission0.id AS infopermissionid,
    shop_permission1.label AS shoppermission,
    shop_permission1.id AS shoppermissionid
FROM ((rel_shop_permission
     LEFT JOIN info_permission info_permission0 ON
         ((rel_shop_permission.info_permission_id = info_permission0.id)))
     LEFT JOIN shop_permission shop_permission1 ON
         ((rel_shop_permission.shop_permission_id = shop_permission1.id)));

--
-- Definition for view rel_user_details_view (OID = 81070) : 
--
CREATE VIEW public.rel_user_details_view AS
SELECT rel_user_details.id,
    user_detail0.label AS userdetail,
    user_detail0.id AS userdetailid,
    (((users1.lastname)::text || ' '::text) || (users1.firstname)::text) AS users,
    users1.id AS usersid,
    users1.user_color AS usersusercolor
FROM ((rel_user_details
     LEFT JOIN user_detail user_detail0 ON
         ((rel_user_details.user_details_id = user_detail0.id)))
     LEFT JOIN users users1 ON ((rel_user_details.users_id = users1.id)));

--
-- Definition for view req_serv_hotel_view (OID = 81075) : 
--
CREATE VIEW public.req_serv_hotel_view AS
SELECT req_serv_hotel.id,
    req_serv_hotel.version,
    req_serv_hotel.createdby,
    req_serv_hotel.createon,
    req_serv_hotel.firmid AS firm,
    req_serv_hotel.lastmodifiedby,
    req_serv_hotel.modifyon,
    req_serv_hotel.serieskey,
    req_serv_hotel.label,
    req_serv_hotel.accept,
    req_serv_hotel.datedifference,
    req_serv_hotel.decline,
    req_serv_hotel.departure,
    req_serv_hotel.descr,
    req_serv_hotel.payment_type AS paymenttype,
    req_serv_hotel.price,
    req_serv_hotel.progress,
    req_serv_hotel.race,
    req_serv_hotel.room_count AS roomcount,
    req_serv_hotel.singleprice,
    req_serv_hotel.tariffcurrency,
    req_serv_hotel.request_number AS requestnumber,
    req_serv_hotel.cancel,
    req_serv_hotel.confirm,
    req_serv_hotel.archived,
    req_serv_hotel.popularity,
    doc_documents0.originalfilename AS docdocumentsbydocumentforuser,
    doc_documents0.id AS docdocumentsbydocumentforuserid,
    doc_documents1.originalfilename AS docdocumentsbydocumentforhotel,
    doc_documents1.id AS docdocumentsbydocumentforhotelid,
    (((payment_price2.price || ' ['::text) || payment_price2.humannumber)
        || ']'::text) AS paymentprice,
    payment_price2.id AS paymentpriceid,
    ''::text AS paymenttariff,
    payment_tariff3.id AS paymenttariffid,
    serv_hotel4.label AS servhotel,
    serv_hotel4.id AS servhotelid,
    serv_hotel_room5.label AS servhotelroom,
    serv_hotel_room5.id AS servhotelroomid,
    (((users6.lastname)::text || ' '::text) || (users6.firstname)::text) AS
        usersbyrequestuser,
    users6.id AS usersbyrequestuserid,
    users6.user_color AS usersbyrequestuserusercolor,
    (((users7.lastname)::text || ' '::text) || (users7.firstname)::text) AS
        usersbyresponseuser,
    users7.id AS usersbyresponseuserid,
    users7.user_color AS usersbyresponseuserusercolor
FROM ((((((((req_serv_hotel
     LEFT JOIN doc_documents doc_documents0 ON
         ((req_serv_hotel.document_for_user_id = doc_documents0.id)))
     LEFT JOIN doc_documents doc_documents1 ON
         ((req_serv_hotel.document_for_hotel_id = doc_documents1.id)))
     LEFT JOIN payment_price payment_price2 ON
         ((req_serv_hotel.payment_price_id = payment_price2.id)))
     LEFT JOIN payment_tariff payment_tariff3 ON
         ((req_serv_hotel.payment_tariff_id = payment_tariff3.id)))
     LEFT JOIN serv_hotel serv_hotel4 ON ((req_serv_hotel.serv_hotel_id =
         serv_hotel4.id)))
     LEFT JOIN serv_hotel_room serv_hotel_room5 ON
         ((req_serv_hotel.serv_hotel_room_id = serv_hotel_room5.id)))
     LEFT JOIN users users6 ON ((req_serv_hotel.request_user_id = users6.id)))
     LEFT JOIN users users7 ON ((req_serv_hotel.response_user_id = users7.id)));

--
-- Definition for view serv_hotel_view (OID = 81080) : 
--
CREATE VIEW public.serv_hotel_view AS
SELECT serv_hotel.id,
    serv_hotel.version,
    serv_hotel.createdby,
    serv_hotel.createon,
    serv_hotel.firmid AS firm,
    serv_hotel.lastmodifiedby,
    serv_hotel.modifyon,
    serv_hotel.serieskey,
    serv_hotel.label,
    serv_hotel.blacklist,
    serv_hotel.condition_text AS conditiontext,
    serv_hotel.descr,
    serv_hotel.descr_internal AS descrinternal,
    serv_hotel.favorite,
    serv_hotel.freesale,
    serv_hotel.problem,
    serv_hotel.showonline,
    serv_hotel.starcount,
    serv_hotel.synopsis,
    serv_hotel.timedeparture,
    serv_hotel.timeearlyrace,
    serv_hotel.timelatedeparture,
    serv_hotel.timerace,
    serv_hotel.whereroomsarebooked,
    serv_hotel.popularity,
    ((((info_contact_information0.contact)::text || ' ['::text) ||
        (info_contact_information0.phone)::text) || ']'::text) AS
        infocontactinformation,
    info_contact_information0.id AS infocontactinformationid,
    location_address1.label AS locationaddress,
    location_address1.id AS locationaddressid,
    location_cities2.cityname AS locationcities,
    location_cities2.id AS locationcitiesid,
    location_countries3.countryname AS locationcountries,
    location_countries3.id AS locationcountriesid,
    payment_details4.full_name AS paymentdetails,
    payment_details4.id AS paymentdetailsid
FROM (((((serv_hotel
     LEFT JOIN info_contact_information info_contact_information0 ON
         ((serv_hotel.contactinformation_id = info_contact_information0.id)))
     LEFT JOIN location_address location_address1 ON
         ((serv_hotel.address_id = location_address1.id)))
     LEFT JOIN location_cities location_cities2 ON
         ((serv_hotel.locationcities_id = location_cities2.id)))
     LEFT JOIN location_countries location_countries3 ON
         ((serv_hotel.locationcountries_id = location_countries3.id)))
     LEFT JOIN payment_details payment_details4 ON
         ((serv_hotel.payment_details_id = payment_details4.id)));

--
-- Definition for view serv_hotel_room_view (OID = 81085) : 
--
CREATE VIEW public.serv_hotel_room_view AS
SELECT serv_hotel_room.id,
    serv_hotel_room.version,
    serv_hotel_room.createdby,
    serv_hotel_room.createon,
    serv_hotel_room.firmid AS firm,
    serv_hotel_room.lastmodifiedby,
    serv_hotel_room.modifyon,
    serv_hotel_room.serieskey,
    serv_hotel_room.label,
    serv_hotel_room.breakfast,
    serv_hotel_room.descr,
    serv_hotel_room.guest_number AS guestnumber,
    serv_hotel_room.room_number AS roomnumber,
    serv_hotel_room.dinner,
    serv_hotel_room.lunch,
    serv_hotel_room.discount,
    serv_hotel_room.is_discount AS isdiscount,
    serv_hotel_room.commission,
    serv_hotel_room.fresale,
    serv_hotel_room.fresale_today AS fresaletoday,
    serv_hotel_room.fresale_enabled AS fresaleenabled,
    serv_hotel_room.fresale_start AS fresalestart,
    serv_hotel_room.fresale_end AS fresaleend,
    serv_hotel_room.is_commission AS iscommission,
    serv_hotel_room.popularity,
    dict_global0.dict_value AS dictglobal,
    dict_global0.id AS dictglobalid,
    ''::text AS paymenttariffbycosttarriff,
    payment_tariff1.id AS paymenttariffbycosttarriffid,
    ''::text AS paymenttariffbyrrtarriff,
    payment_tariff2.id AS paymenttariffbyrrtarriffid,
    ''::text AS paymenttariffshop,
    payment_tariff_shop3.id AS paymenttariffshopid,
    serv_hotel4.label AS servhotel,
    serv_hotel4.id AS servhotelid
FROM (((((serv_hotel_room
     LEFT JOIN dict_global dict_global0 ON ((serv_hotel_room.room_type_id =
         dict_global0.id)))
     LEFT JOIN payment_tariff payment_tariff1 ON
         ((serv_hotel_room.cost_tarriff_id = payment_tariff1.id)))
     LEFT JOIN payment_tariff payment_tariff2 ON
         ((serv_hotel_room.rr_tarriff_id = payment_tariff2.id)))
     LEFT JOIN payment_tariff_shop payment_tariff_shop3 ON
         ((serv_hotel_room.shop_tarriff_id = payment_tariff_shop3.id)))
     LEFT JOIN serv_hotel serv_hotel4 ON ((serv_hotel_room.hotel_id =
         serv_hotel4.id)));

--
-- Definition for view serv_transfer_view (OID = 81090) : 
--
CREATE VIEW public.serv_transfer_view AS
SELECT serv_transfer.id,
    serv_transfer.version,
    serv_transfer.createdby,
    serv_transfer.createon,
    serv_transfer.firmid AS firm,
    serv_transfer.lastmodifiedby,
    serv_transfer.modifyon,
    serv_transfer.serieskey,
    serv_transfer.label,
    serv_transfer.date_from AS datefrom,
    serv_transfer.date_to AS dateto,
    serv_transfer.descr,
    serv_transfer.passengers_phones AS passengersphones,
    serv_transfer.price,
    serv_transfer.transfer_name AS transfername,
    serv_transfer.visit_table AS visittable,
    serv_transfer.popularity,
    curr_currency0.currencyname AS currcurrency,
    curr_currency0.id AS currcurrencyid,
    dict_global1.dict_value AS dictglobalbypaymenttype,
    dict_global1.id AS dictglobalbypaymenttypeid,
    dict_global2.dict_value AS dictglobalbytypetransfer,
    dict_global2.id AS dictglobalbytypetransferid,
    dict_global3.dict_value AS dictglobalbytransport,
    dict_global3.id AS dictglobalbytransportid,
    location_cities4.cityname AS locationcities,
    location_cities4.id AS locationcitiesid,
    location_countries5.countryname AS locationcountries,
    location_countries5.id AS locationcountriesid,
    tm_account6.account_name AS tmaccount,
    tm_account6.id AS tmaccountid
FROM (((((((serv_transfer
     LEFT JOIN curr_currency curr_currency0 ON ((serv_transfer.currency_id
         = curr_currency0.id)))
     LEFT JOIN dict_global dict_global1 ON ((serv_transfer.payment_type_id
         = dict_global1.id)))
     LEFT JOIN dict_global dict_global2 ON ((serv_transfer.type_transfer_id
         = dict_global2.id)))
     LEFT JOIN dict_global dict_global3 ON ((serv_transfer.transport_id =
         dict_global3.id)))
     LEFT JOIN location_cities location_cities4 ON
         ((serv_transfer.location_cities_id = location_cities4.id)))
     LEFT JOIN location_countries location_countries5 ON
         ((serv_transfer.location_countries_id = location_countries5.id)))
     LEFT JOIN tm_account tm_account6 ON ((serv_transfer.account_id =
         tm_account6.id)));

--
-- Definition for view serv_transfer_route_view (OID = 81095) : 
--
CREATE VIEW public.serv_transfer_route_view AS
SELECT serv_transfer_route.id,
    serv_transfer_route.version,
    serv_transfer_route.createdby,
    serv_transfer_route.createon,
    serv_transfer_route.firmid AS firm,
    serv_transfer_route.lastmodifiedby,
    serv_transfer_route.modifyon,
    serv_transfer_route.serieskey,
    serv_transfer_route.label,
    serv_transfer_route.descr,
    serv_transfer_route.driver,
    serv_transfer_route.driver_phone AS driverphone,
    serv_transfer_route.fixed_allowance AS fixedallowance,
    serv_transfer_route.free,
    serv_transfer_route.percentage_of_allowances AS percentageofallowances,
    serv_transfer_route.sum,
    serv_transfer_route.popularity,
    curr_currency0.currencyname AS currcurrency,
    curr_currency0.id AS currcurrencyid,
    serv_transfer1.label AS servtransfer,
    serv_transfer1.id AS servtransferid
FROM ((serv_transfer_route
     LEFT JOIN curr_currency curr_currency0 ON
         ((serv_transfer_route.currency_id = curr_currency0.id)))
     LEFT JOIN serv_transfer serv_transfer1 ON
         ((serv_transfer_route.serv_transfer_id = serv_transfer1.id)));

--
-- Definition for view serv_transfer_route_point_view (OID = 81100) : 
--
CREATE VIEW public.serv_transfer_route_point_view AS
SELECT serv_transfer_route_point.id,
    serv_transfer_route_point.version,
    serv_transfer_route_point.createdby,
    serv_transfer_route_point.createon,
    serv_transfer_route_point.firmid AS firm,
    serv_transfer_route_point.lastmodifiedby,
    serv_transfer_route_point.modifyon,
    serv_transfer_route_point.serieskey,
    serv_transfer_route_point.label,
    serv_transfer_route_point.fixed_allowance AS fixedallowance,
    serv_transfer_route_point.free,
    serv_transfer_route_point.percentage_of_allowances AS percentageofallowances,
    serv_transfer_route_point.point_from AS pointfrom,
    serv_transfer_route_point.point_to AS pointto,
    serv_transfer_route_point.start_on AS starton,
    serv_transfer_route_point.sum,
    serv_transfer_route_point.popularity,
    serv_transfer_route0.label AS servtransferroute,
    serv_transfer_route0.id AS servtransferrouteid
FROM (serv_transfer_route_point
     LEFT JOIN serv_transfer_route serv_transfer_route0 ON
         ((serv_transfer_route_point.transfer_route_id =
         serv_transfer_route0.id)));

--
-- Definition for view shop_permission_view (OID = 81105) : 
--
CREATE VIEW public.shop_permission_view AS
SELECT shop_permission.id,
    shop_permission.version,
    shop_permission.allocated_firm_id AS allocatedfirm,
    shop_permission.physical_person AS physicalperson,
    shop_permission.corporate_customer AS corporatecustomer,
    shop_permission.travel_agency AS travelagency,
    shop_permission.travel_operator AS traveloperator,
    shop_permission.partner,
    shop_permission.createdby,
    shop_permission.createon,
    shop_permission.firmid AS firm,
    shop_permission.lastmodifiedby,
    shop_permission.modifyon,
    shop_permission.popularity,
    shop_permission.serieskey,
    shop_permission.label
FROM shop_permission;

--
-- Definition for view shop_user_view (OID = 81109) : 
--
CREATE VIEW public.shop_user_view AS
SELECT shop_user.id,
    shop_user.version,
    shop_user.createdby,
    shop_user.createon,
    shop_user.firmid AS firm,
    shop_user.lastmodifiedby,
    shop_user.modifyon,
    shop_user.serieskey,
    shop_user.activated,
    shop_user.activationkey,
    shop_user.email,
    shop_user.enabled,
    shop_user.firstname,
    shop_user.lastname,
    shop_user.password,
    shop_user.username,
    shop_user.image_id AS image,
    shop_user.token,
    shop_user.phonenumber,
    shop_user.popularity,
    shop_user.shop_permission_id AS shoppermission,
    shop_user.label
FROM shop_user;

--
-- Definition for view tm_account_view (OID = 81113) : 
--
CREATE VIEW public.tm_account_view AS
SELECT tm_account.id,
    tm_account.version,
    tm_account.createdby,
    tm_account.createon,
    tm_account.firmid AS firm,
    tm_account.lastmodifiedby,
    tm_account.modifyon,
    tm_account.serieskey,
    tm_account.account_fullname AS accountfullname,
    tm_account.account_name AS accountname,
    tm_account.descr,
    tm_account.popularity,
    location_countries0.countryname AS locationcountries,
    location_countries0.id AS locationcountriesid
FROM (tm_account
     LEFT JOIN location_countries location_countries0 ON
         ((tm_account.residency_id = location_countries0.id)));

--
-- Definition for view tm_contact_view (OID = 81118) : 
--
CREATE VIEW public.tm_contact_view AS
SELECT tm_contact.id,
    tm_contact.version,
    tm_contact.createdby,
    tm_contact.createon,
    tm_contact.firmid AS firm,
    tm_contact.lastmodifiedby,
    tm_contact.modifyon,
    tm_contact.serieskey,
    tm_contact.birthday,
    tm_contact.contact_name AS contactname,
    tm_contact.contact_patronymic AS contactpatronymic,
    tm_contact.contact_surname AS contactsurname,
    tm_contact.descr,
    tm_contact.passport_end_date AS passportenddate,
    tm_contact.passport_number AS passportnumber,
    tm_contact.passport_start_date AS passportstartdate,
    tm_contact.popularity,
    location_countries0.countryname AS locationcountries,
    location_countries0.id AS locationcountriesid
FROM (tm_contact
     LEFT JOIN location_countries location_countries0 ON
         ((tm_contact.citizenship_id = location_countries0.id)));

--
-- Definition for view tm_contact_easy_view (OID = 81123) : 
--
CREATE VIEW public.tm_contact_easy_view AS
SELECT tm_contact_easy.id,
    tm_contact_easy.version,
    tm_contact_easy.createdby,
    tm_contact_easy.createon,
    tm_contact_easy.firmid AS firm,
    tm_contact_easy.lastmodifiedby,
    tm_contact_easy.modifyon,
    tm_contact_easy.serieskey,
    tm_contact_easy.label,
    tm_contact_easy.descr,
    tm_contact_easy.email,
    tm_contact_easy.man_foman AS manfoman,
    tm_contact_easy.phone,
    tm_contact_easy.id_card AS card,
    tm_contact_easy.identity_number AS entitynumber,
    tm_contact_easy.passport,
    tm_contact_easy.popularity,
    location_countries0.countryname AS locationcountries,
    location_countries0.id AS locationcountriesid,
    req_serv_hotel1.label AS reqservhotel,
    req_serv_hotel1.id AS reqservhotelid
FROM ((tm_contact_easy
     LEFT JOIN location_countries location_countries0 ON
         ((tm_contact_easy.country_id = location_countries0.id)))
     LEFT JOIN req_serv_hotel req_serv_hotel1 ON
         ((tm_contact_easy.req_serv_hotel_id = req_serv_hotel1.id)));

--
-- Definition for view tm_firms_view (OID = 81128) : 
--
CREATE VIEW public.tm_firms_view AS
SELECT tm_firms.id,
    tm_firms.version,
    tm_firms.createdby,
    tm_firms.createon,
    tm_firms.firmid AS firm,
    tm_firms.lastmodifiedby,
    tm_firms.modifyon,
    tm_firms.serieskey,
    tm_firms.label,
    tm_firms.accountid AS account,
    tm_firms.active,
    tm_firms.firm_name AS firmname,
    tm_firms.lastpay,
    tm_firms.mounthcount,
    tm_firms.popularity
FROM tm_firms;

--
-- Definition for view tm_firm_settings_view (OID = 81132) : 
--
CREATE VIEW public.tm_firm_settings_view AS
SELECT tm_firm_settings.id,
    tm_firm_settings.version,
    tm_firm_settings.logo_id AS logo,
    tm_firm_settings.brand,
    tm_firm_settings.createdby,
    tm_firm_settings.createon,
    tm_firm_settings.firmid AS firm,
    tm_firm_settings.lastmodifiedby,
    tm_firm_settings.modifyon,
    tm_firm_settings.popularity,
    tm_firm_settings.serieskey,
    doc_documents0.originalfilename AS docdocuments,
    doc_documents0.id AS docdocumentsid
FROM (tm_firm_settings
     LEFT JOIN doc_documents doc_documents0 ON
         ((tm_firm_settings.doc_documents_id = doc_documents0.id)));

--
-- Definition for view tm_image_view (OID = 81137) : 
--
CREATE VIEW public.tm_image_view AS
SELECT tm_image.id,
    tm_image.version,
    tm_image.createdby,
    tm_image.createon,
    tm_image.firmid AS firm,
    tm_image.lastmodifiedby,
    tm_image.modifyon,
    tm_image.serieskey,
    tm_image.contenttype,
    tm_image.extension,
    tm_image.name,
    tm_image.originalfilename,
    tm_image.path,
    tm_image.size,
    tm_image.popularity
FROM tm_image;

--
-- Definition for view tm_mail_newsletter_view (OID = 81141) : 
--
CREATE VIEW public.tm_mail_newsletter_view AS
SELECT tm_mail_newsletter.id,
    tm_mail_newsletter.version,
    tm_mail_newsletter.subject,
    tm_mail_newsletter.content,
    tm_mail_newsletter.background_color AS backgroundcolor,
    tm_mail_newsletter.badge,
    tm_mail_newsletter.badge_type AS badgetype,
    tm_mail_newsletter.createdby,
    tm_mail_newsletter.createon,
    tm_mail_newsletter.firmid AS firm,
    tm_mail_newsletter.lastmodifiedby,
    tm_mail_newsletter.modifyon,
    tm_mail_newsletter.popularity,
    tm_mail_newsletter.serieskey,
    tm_mail_newsletter.label
FROM tm_mail_newsletter;

--
-- Definition for view tm_mail_newsletter_group_view (OID = 81145) : 
--
CREATE VIEW public.tm_mail_newsletter_group_view AS
SELECT tm_mail_newsletter_group.id,
    tm_mail_newsletter_group.version,
    tm_mail_newsletter_group.email,
    tm_mail_newsletter_group.name,
    tm_mail_newsletter_group.createdby,
    tm_mail_newsletter_group.createon,
    tm_mail_newsletter_group.firmid AS firm,
    tm_mail_newsletter_group.lastmodifiedby,
    tm_mail_newsletter_group.modifyon,
    tm_mail_newsletter_group.popularity,
    tm_mail_newsletter_group.serieskey,
    tm_mail_newsletter_group.label
FROM tm_mail_newsletter_group;

--
-- Definition for view tm_user_info_view (OID = 81149) : 
--
CREATE VIEW public.tm_user_info_view AS
SELECT tm_user_info.id,
    tm_user_info.version,
    tm_user_info.createdby,
    tm_user_info.createon,
    tm_user_info.firmid AS firm,
    tm_user_info.lastmodifiedby,
    tm_user_info.modifyon,
    tm_user_info.serieskey,
    tm_user_info.label,
    tm_user_info.browser,
    tm_user_info.browser_version AS browserversion,
    tm_user_info.last_login AS lastlogin,
    tm_user_info.platform,
    tm_user_info.platformversion,
    tm_user_info.proxy_content AS proxycontent,
    tm_user_info.remote_host AS remotehost,
    tm_user_info.user_agent AS useragent,
    tm_user_info.user_ip_address AS useripaddress,
    tm_user_info.username,
    tm_user_info.popularity
FROM tm_user_info;

--
-- Definition for view user_detail_view (OID = 81153) : 
--
CREATE VIEW public.user_detail_view AS
SELECT user_detail.id,
    user_detail.version,
    user_detail.company_name AS companyname,
    user_detail.company_site AS companysite,
    user_detail.createdby,
    user_detail.createon,
    user_detail.firmid AS firm,
    user_detail.lastmodifiedby,
    user_detail.modifyon,
    user_detail.popularity,
    user_detail.serieskey,
    user_detail.label
FROM user_detail;

--
-- Definition for view user_roles_view (OID = 81157) : 
--
CREATE VIEW public.user_roles_view AS
SELECT user_roles.id,
    user_roles.role,
    (((users0.lastname)::text || ' '::text) || (users0.firstname)::text) AS users,
    users0.id AS usersid,
    users0.user_color AS usersusercolor
FROM (user_roles
     LEFT JOIN users users0 ON ((user_roles.user_id = users0.id)));

--
-- Definition for view users_view (OID = 81162) : 
--
CREATE VIEW public.users_view AS
SELECT users.id,
    users.version,
    users.createdby,
    users.createon,
    users.firmid AS firm,
    users.lastmodifiedby,
    users.modifyon,
    users.serieskey,
    users.activated,
    users.activationkey,
    users.email,
    users.enabled,
    users.firstname,
    users.landingpage,
    users.langkey,
    users.lastname,
    users.password,
    users.username,
    users.token,
    users.phonenumber,
    users.user_color AS usercolor,
    users.popularity,
    users.shop_user AS shopuser,
    users.physical_person AS physicalperson,
    users.legal_entity AS legalentity,
    (((tm_image0.name)::text || '.'::text) || (tm_image0.extension)::text)
        AS tmimage,
    tm_image0.id AS tmimageid
FROM (users
     LEFT JOIN tm_image tm_image0 ON ((users.image_id = tm_image0.id)));

--
-- Definition for view user_registration_request_view (OID = 81167) : 
--
CREATE VIEW public.user_registration_request_view AS
SELECT usr0.id,
    usr0.createdby,
    usr0.createon,
    usr0.firmid AS firm,
    usr0.lastmodifiedby,
    usr0.modifyon,
    usr0.serieskey,
    usr0.version,
    usr0.activated,
    usr0.activationkey,
    usr0.email,
    usr0.enabled,
    usr0.firstname,
    usr0.lastname,
    usr0.username,
    usr0.token,
    usr0.phonenumber,
    usr0.popularity
FROM users usr0
WHERE ((((usr0.shop_user = true) AND (usr0.activated IS NULL)) AND
    (usr0.activationkey IS NOT NULL)) AND (usr0.legal_entity = true));

--
-- Definition for view payment_price_simple_view (OID = 81171) : 
--
CREATE VIEW public.payment_price_simple_view AS
SELECT DISTINCT ON (payment_price.payment_tariff_id) payment_price.id,
    payment_price.createdby,
    payment_price.createon,
    payment_price.firmid,
    payment_price.lastmodifiedby,
    payment_price.modifyon,
    payment_price.serieskey,
    payment_price.version,
    payment_price.humannumber,
    payment_price.price,
    payment_price.payment_tariff_id
FROM payment_price
ORDER BY payment_price.payment_tariff_id, payment_price.price;

--
-- Definition for view payment_price_shop_simple_view (OID = 81175) : 
--
CREATE VIEW public.payment_price_shop_simple_view AS
SELECT DISTINCT ON (payment_price_shop.payment_tariff_shop_id)
    payment_price_shop.id,
    payment_price_shop.createdby,
    payment_price_shop.createon,
    payment_price_shop.firmid,
    payment_price_shop.lastmodifiedby,
    payment_price_shop.modifyon,
    payment_price_shop.serieskey,
    payment_price_shop.version,
    payment_price_shop.humannumber,
    payment_price_shop.price,
    payment_price_shop.payment_tariff_shop_id
FROM payment_price_shop
ORDER BY payment_price_shop.payment_tariff_shop_id, payment_price_shop.price;

--
-- Definition for view payment_tariff_simple_view (OID = 81179) : 
--
CREATE VIEW public.payment_tariff_simple_view AS
SELECT payment_tariff.id,
    payment_tariff.createdby,
    payment_tariff.createon,
    payment_tariff.firmid,
    payment_tariff.lastmodifiedby,
    payment_tariff.modifyon,
    payment_tariff.serieskey,
    payment_tariff.version,
    payment_price_simple_view.price,
    payment_price_simple_view.humannumber,
    (payment_price_simple_view.price *
        (payment_price_simple_view.humannumber)::numeric) AS cost
FROM (payment_tariff
     JOIN payment_price_simple_view ON ((payment_tariff.id =
         payment_price_simple_view.payment_tariff_id)))
ORDER BY (payment_price_simple_view.price *
    (payment_price_simple_view.humannumber)::numeric);

--
-- Definition for view payment_tariff_shop_simple_view (OID = 81183) : 
--
CREATE VIEW public.payment_tariff_shop_simple_view AS
SELECT payment_tariff_shop.id,
    payment_tariff_shop.createdby,
    payment_tariff_shop.createon,
    payment_tariff_shop.firmid,
    payment_tariff_shop.lastmodifiedby,
    payment_tariff_shop.modifyon,
    payment_tariff_shop.serieskey,
    payment_tariff_shop.version,
    payment_price_shop_simple_view.price,
    payment_price_shop_simple_view.humannumber,
    (payment_price_shop_simple_view.price *
        (payment_price_shop_simple_view.humannumber)::numeric) AS cost
FROM (payment_tariff_shop
     JOIN payment_price_shop_simple_view ON ((payment_tariff_shop.id =
         payment_price_shop_simple_view.payment_tariff_shop_id)))
ORDER BY (payment_price_shop_simple_view.price *
    (payment_price_shop_simple_view.humannumber)::numeric);

--
-- Definition for view rel_serv_hotel_image_simple_view (OID = 81187) : 
--
CREATE VIEW public.rel_serv_hotel_image_simple_view AS
SELECT DISTINCT ON (rel_serv_hotel_image.serv_hotel_id) rel_serv_hotel_image.id,
    rel_serv_hotel_image.serv_hotel_id,
    (((tm_image.name)::text || '.'::text) || (tm_image.extension)::text) AS image
FROM (rel_serv_hotel_image
     JOIN tm_image ON ((rel_serv_hotel_image.image_id = tm_image.id)));

--
-- Definition for view rel_serv_hotel_room_image_simple_view (OID = 81191) : 
--
CREATE VIEW public.rel_serv_hotel_room_image_simple_view AS
SELECT DISTINCT ON (rel_serv_hotel_room_image.serv_hotel_room_id)
    rel_serv_hotel_room_image.id,
    rel_serv_hotel_room_image.serv_hotel_room_id,
    (((tm_image.name)::text || '.'::text) || (tm_image.extension)::text) AS image
FROM (rel_serv_hotel_room_image
     JOIN tm_image ON ((rel_serv_hotel_room_image.image_id = tm_image.id)));

--
-- Definition for view req_serv_hotel_archived_view (OID = 81195) : 
--
CREATE VIEW public.req_serv_hotel_archived_view AS
SELECT req_serv_hotel_view.id,
    req_serv_hotel_view.version,
    req_serv_hotel_view.createdby,
    req_serv_hotel_view.createon,
    req_serv_hotel_view.firm,
    req_serv_hotel_view.lastmodifiedby,
    req_serv_hotel_view.modifyon,
    req_serv_hotel_view.serieskey,
    req_serv_hotel_view.label,
    req_serv_hotel_view.accept,
    req_serv_hotel_view.datedifference,
    req_serv_hotel_view.decline,
    req_serv_hotel_view.departure,
    req_serv_hotel_view.descr,
    req_serv_hotel_view.paymenttype,
    req_serv_hotel_view.price,
    req_serv_hotel_view.progress,
    req_serv_hotel_view.race,
    req_serv_hotel_view.roomcount,
    req_serv_hotel_view.singleprice,
    req_serv_hotel_view.tariffcurrency,
    req_serv_hotel_view.requestnumber,
    req_serv_hotel_view.cancel,
    req_serv_hotel_view.confirm,
    req_serv_hotel_view.archived,
    req_serv_hotel_view.popularity,
    req_serv_hotel_view.docdocumentsbydocumentforuser,
    req_serv_hotel_view.docdocumentsbydocumentforuserid,
    req_serv_hotel_view.docdocumentsbydocumentforhotel,
    req_serv_hotel_view.docdocumentsbydocumentforhotelid,
    req_serv_hotel_view.paymentprice,
    req_serv_hotel_view.paymentpriceid,
    req_serv_hotel_view.paymenttariff,
    req_serv_hotel_view.paymenttariffid,
    req_serv_hotel_view.servhotel,
    req_serv_hotel_view.servhotelid,
    req_serv_hotel_view.servhotelroom,
    req_serv_hotel_view.servhotelroomid,
    req_serv_hotel_view.usersbyrequestuser,
    req_serv_hotel_view.usersbyrequestuserid,
    req_serv_hotel_view.usersbyrequestuserusercolor,
    req_serv_hotel_view.usersbyresponseuser,
    req_serv_hotel_view.usersbyresponseuserid,
    req_serv_hotel_view.usersbyresponseuserusercolor,
        CASE
            WHEN ((req_serv_hotel_view.accept IS NULL) OR
                (req_serv_hotel_view.accept = false)) THEN false
            ELSE true
        END AS status,
    ((req_serv_hotel_view.race || ' - '::text) ||
        req_serv_hotel_view.departure) AS reqdate
FROM req_serv_hotel_view
WHERE (req_serv_hotel_view.archived = true);

--
-- Definition for view req_serv_hotel_open_view (OID = 81200) : 
--
CREATE VIEW public.req_serv_hotel_open_view AS
SELECT req_serv_hotel_view.id,
    req_serv_hotel_view.version,
    req_serv_hotel_view.createdby,
    req_serv_hotel_view.createon,
    req_serv_hotel_view.firm,
    req_serv_hotel_view.lastmodifiedby,
    req_serv_hotel_view.modifyon,
    req_serv_hotel_view.serieskey,
    req_serv_hotel_view.label,
    req_serv_hotel_view.accept,
    req_serv_hotel_view.datedifference,
    req_serv_hotel_view.decline,
    req_serv_hotel_view.departure,
    req_serv_hotel_view.descr,
    req_serv_hotel_view.paymenttype,
    req_serv_hotel_view.price,
    req_serv_hotel_view.progress,
    req_serv_hotel_view.race,
    req_serv_hotel_view.roomcount,
    req_serv_hotel_view.singleprice,
    req_serv_hotel_view.tariffcurrency,
    req_serv_hotel_view.requestnumber,
    req_serv_hotel_view.cancel,
    req_serv_hotel_view.confirm,
    req_serv_hotel_view.archived,
    req_serv_hotel_view.popularity,
    req_serv_hotel_view.docdocumentsbydocumentforuser,
    req_serv_hotel_view.docdocumentsbydocumentforuserid,
    req_serv_hotel_view.docdocumentsbydocumentforhotel,
    req_serv_hotel_view.docdocumentsbydocumentforhotelid,
    req_serv_hotel_view.paymentprice,
    req_serv_hotel_view.paymentpriceid,
    req_serv_hotel_view.paymenttariff,
    req_serv_hotel_view.paymenttariffid,
    req_serv_hotel_view.servhotel,
    req_serv_hotel_view.servhotelid,
    req_serv_hotel_view.servhotelroom,
    req_serv_hotel_view.servhotelroomid,
    req_serv_hotel_view.usersbyrequestuser,
    req_serv_hotel_view.usersbyrequestuserid,
    req_serv_hotel_view.usersbyrequestuserusercolor,
    req_serv_hotel_view.usersbyresponseuser,
    req_serv_hotel_view.usersbyresponseuserid,
    req_serv_hotel_view.usersbyresponseuserusercolor
FROM req_serv_hotel_view
WHERE (((req_serv_hotel_view.archived = false) OR
    (req_serv_hotel_view.archived IS NULL)) AND
    ((req_serv_hotel_view.confirm = false) OR (req_serv_hotel_view.confirm
    IS NULL)));

--
-- Definition for view req_serv_hotel_processed_view (OID = 81205) : 
--
CREATE VIEW public.req_serv_hotel_processed_view AS
SELECT req_serv_hotel_view.id,
    req_serv_hotel_view.version,
    req_serv_hotel_view.createdby,
    req_serv_hotel_view.createon,
    req_serv_hotel_view.firm,
    req_serv_hotel_view.lastmodifiedby,
    req_serv_hotel_view.modifyon,
    req_serv_hotel_view.serieskey,
    req_serv_hotel_view.label,
    req_serv_hotel_view.accept,
    req_serv_hotel_view.datedifference,
    req_serv_hotel_view.decline,
    req_serv_hotel_view.departure,
    req_serv_hotel_view.descr,
    req_serv_hotel_view.paymenttype,
    req_serv_hotel_view.price,
    req_serv_hotel_view.progress,
    req_serv_hotel_view.race,
    req_serv_hotel_view.roomcount,
    req_serv_hotel_view.singleprice,
    req_serv_hotel_view.tariffcurrency,
    req_serv_hotel_view.requestnumber,
    req_serv_hotel_view.cancel,
    req_serv_hotel_view.confirm,
    req_serv_hotel_view.archived,
    req_serv_hotel_view.popularity,
    req_serv_hotel_view.docdocumentsbydocumentforuser,
    req_serv_hotel_view.docdocumentsbydocumentforuserid,
    req_serv_hotel_view.docdocumentsbydocumentforhotel,
    req_serv_hotel_view.docdocumentsbydocumentforhotelid,
    req_serv_hotel_view.paymentprice,
    req_serv_hotel_view.paymentpriceid,
    req_serv_hotel_view.paymenttariff,
    req_serv_hotel_view.paymenttariffid,
    req_serv_hotel_view.servhotel,
    req_serv_hotel_view.servhotelid,
    req_serv_hotel_view.servhotelroom,
    req_serv_hotel_view.servhotelroomid,
    req_serv_hotel_view.usersbyrequestuser,
    req_serv_hotel_view.usersbyrequestuserid,
    req_serv_hotel_view.usersbyrequestuserusercolor,
    req_serv_hotel_view.usersbyresponseuser,
    req_serv_hotel_view.usersbyresponseuserid,
    req_serv_hotel_view.usersbyresponseuserusercolor
FROM req_serv_hotel_view
WHERE ((req_serv_hotel_view.confirm = true) AND
    ((req_serv_hotel_view.archived = false) OR
    (req_serv_hotel_view.archived IS NULL)));

--
-- Definition for view shop_room_tarriff_corporate_rate_view (OID = 81210) : 
--
CREATE VIEW public.shop_room_tarriff_corporate_rate_view AS
SELECT data.id,
    data.createdby,
    data.createon,
    data.firmid,
    data.lastmodifiedby,
    data.modifyon,
    data.serieskey,
    data.version,
    data.humannumber,
    data.price,
    data.payment_tariff_id,
    data.payment_tariff_version,
    data.room_id,
    data.percentage_of_allowances,
    data.is_percentage_of_allowances,
    data.usdid,
    data.usdversion,
    data.usdnameru,
    data.usdcourse,
    data.usdcurrencysign,
    data.kztcurrencysign,
    data.currcurrencycourse,
    data.currcurrencyisocode,
    data.currcurrency,
    data.currcurrencyid,
    data.currcurrencyversion,
    data.currencyname,
    data.cost,
        CASE
            WHEN ((data.currcurrencyisocode)::text = 'USD'::text) THEN
                (COALESCE(data.cost, (1)::numeric) *
                (COALESCE(data.currcurrencycourse, 1))::numeric)
            ELSE data.cost
        END AS cost_national_currency,
        CASE
            WHEN ((data.currcurrencyisocode)::text = 'KZT'::text) THEN
                round((COALESCE(data.cost, (1)::numeric) /
                (COALESCE(data.usdcourse, 1))::numeric))
            ELSE data.cost
        END AS cost_usd_currency
FROM (
    SELECT payment_price.id,
            payment_price.createdby,
            payment_price.createon,
            payment_price.firmid,
            payment_price.lastmodifiedby,
            payment_price.modifyon,
            payment_price.serieskey,
            payment_price.version,
            payment_price.humannumber,
            payment_price.price,
            payment_price.payment_tariff_shop_id AS payment_tariff_id,
            payment_tariff_shop.version AS payment_tariff_version,
            serv_hotel_room.id AS room_id,
            payment_tariff_shop.percentage_of_allowances,
            payment_tariff_shop.is_percentage_of_allowances,
            usd_currency0.id AS usdid,
            usd_currency0.version AS usdversion,
            usd_currency0.nameru AS usdnameru,
            usd_currency0.course AS usdcourse,
            '$'::text AS usdcurrencysign,
            '?'::text AS kztcurrencysign,
            curr_currency0.course AS currcurrencycourse,
            curr_currency0.iso_code AS currcurrencyisocode,
            curr_currency0.currencyname AS currcurrency,
            curr_currency0.id AS currcurrencyid,
            curr_currency0.version AS currcurrencyversion,
                CASE
                    WHEN ((curr_currency0.iso_code)::text = 'USD'::text)
                        THEN '$'::character varying
                    WHEN ((curr_currency0.iso_code)::text = 'KZT'::text)
                        THEN '?'::character varying
                    ELSE curr_currency0.currencyname
                END AS currencyname,
            COALESCE(round(
                CASE
                    WHEN (payment_tariff_shop.is_percentage_of_allowances =
                        true) THEN (payment_price.price +
                        ((payment_price.price / (100)::numeric) *
                        (payment_tariff_shop.percentage_of_allowances)::numeric))
                    WHEN (payment_tariff_shop.is_percentage_of_allowances =
                        false) THEN (payment_price.price +
                        (payment_tariff_shop.percentage_of_allowances)::numeric)
                    ELSE payment_price.price
                END), payment_price.price) AS cost
    FROM ((((serv_hotel_room
             JOIN payment_tariff_shop ON ((serv_hotel_room.shop_tarriff_id
                 = payment_tariff_shop.id)))
             JOIN payment_price_shop payment_price ON
                 ((payment_tariff_shop.id = payment_price.payment_tariff_shop_id)))
             LEFT JOIN curr_currency curr_currency0 ON
                 (((serv_hotel_room.firmid = curr_currency0.firmid) AND
                 ((curr_currency0.iso_code)::text = 'KZT'::text))))
             LEFT JOIN curr_currency usd_currency0 ON
                 (((serv_hotel_room.firmid = usd_currency0.firmid) AND
                 ((usd_currency0.iso_code)::text = 'USD'::text))))
    ) data;

--
-- Definition for view shop_room_tarriff_original_rate_view (OID = 81215) : 
--
CREATE VIEW public.shop_room_tarriff_original_rate_view AS
SELECT data.id,
    data.createdby,
    data.createon,
    data.firmid,
    data.lastmodifiedby,
    data.modifyon,
    data.serieskey,
    data.version,
    data.humannumber,
    data.price,
    data.payment_tariff_id,
    data.payment_tariff_version,
    data.room_id,
    data.percentage_of_allowances,
    data.is_percentage_of_allowances,
    data.usdid,
    data.usdversion,
    data.usdnameru,
    data.usdcourse,
    data.usdcurrencysign,
    data.kztcurrencysign,
    data.currcurrencycourse,
    data.currcurrencyisocode,
    data.currcurrency,
    data.currcurrencyid,
    data.currcurrencyversion,
    data.currencyname,
    data.cost,
        CASE
            WHEN ((data.currcurrencyisocode)::text = 'USD'::text) THEN
                (COALESCE(data.cost, (1)::numeric) *
                (COALESCE(data.currcurrencycourse, 1))::numeric)
            ELSE data.cost
        END AS cost_national_currency,
        CASE
            WHEN ((data.currcurrencyisocode)::text = 'KZT'::text) THEN
                round((COALESCE(data.cost, (1)::numeric) /
                (COALESCE(data.usdcourse, 1))::numeric))
            ELSE data.cost
        END AS cost_usd_currency
FROM (
    SELECT payment_price.id,
            payment_price.createdby,
            payment_price.createon,
            payment_price.firmid,
            payment_price.lastmodifiedby,
            payment_price.modifyon,
            payment_price.serieskey,
            payment_price.version,
            payment_price.humannumber,
            payment_price.price,
            payment_price.payment_tariff_id,
            payment_tariff.version AS payment_tariff_version,
            serv_hotel_room.id AS room_id,
            false AS percentage_of_allowances,
            (0)::numeric AS is_percentage_of_allowances,
            usd_currency0.id AS usdid,
            usd_currency0.version AS usdversion,
            usd_currency0.nameru AS usdnameru,
            usd_currency0.course AS usdcourse,
            '$'::text AS usdcurrencysign,
            '?'::text AS kztcurrencysign,
            curr_currency0.course AS currcurrencycourse,
            curr_currency0.iso_code AS currcurrencyisocode,
            curr_currency0.currencyname AS currcurrency,
            curr_currency0.id AS currcurrencyid,
            curr_currency0.version AS currcurrencyversion,
                CASE
                    WHEN ((curr_currency0.iso_code)::text = 'USD'::text)
                        THEN '$'::character varying
                    WHEN ((curr_currency0.iso_code)::text = 'KZT'::text)
                        THEN '?'::character varying
                    ELSE curr_currency0.currencyname
                END AS currencyname,
            payment_price.price AS cost
    FROM ((((serv_hotel_room
             JOIN payment_tariff ON ((serv_hotel_room.rr_tarriff_id =
                 payment_tariff.id)))
             JOIN payment_price ON ((payment_tariff.id =
                 payment_price.payment_tariff_id)))
             LEFT JOIN curr_currency curr_currency0 ON
                 (((serv_hotel_room.firmid = curr_currency0.firmid) AND
                 ((curr_currency0.iso_code)::text = 'KZT'::text))))
             LEFT JOIN curr_currency usd_currency0 ON
                 (((serv_hotel_room.firmid = usd_currency0.firmid) AND
                 ((usd_currency0.iso_code)::text = 'USD'::text))))
    ) data;

--
-- Definition for view shop_room_tarriff_general_rate_view (OID = 81220) : 
--
CREATE VIEW public.shop_room_tarriff_general_rate_view AS
SELECT COALESCE(original_rate.id, corporate_rate.id) AS id,
    COALESCE(original_rate.payment_tariff_id,
        corporate_rate.payment_tariff_id) AS payment_tariff_id,
    COALESCE(original_rate.payment_tariff_version,
        corporate_rate.payment_tariff_version) AS payment_tariff_version,
    COALESCE(original_rate.version, corporate_rate.version) AS price_version,
    COALESCE(corporate_rate.humannumber, original_rate.humannumber) AS humannumber,
    COALESCE(original_rate.room_id, corporate_rate.room_id) AS room_id,
    COALESCE(corporate_rate.cost, original_rate.cost) AS corporate_rate_cost,
    COALESCE(corporate_rate.cost_national_currency,
        original_rate.cost_national_currency) AS
        corporate_rate_cost_national_currency,
    COALESCE(corporate_rate.cost_usd_currency,
        original_rate.cost_usd_currency) AS corporate_rate_cost_usd_currency,
    COALESCE(corporate_rate.usdcurrencysign, original_rate.usdcurrencysign)
        AS corporate_rate_cost_usdcurrencysign,
    COALESCE(corporate_rate.currcurrencyid, original_rate.currcurrencyid)
        AS corporate_rate_currcurrencyid,
    COALESCE(corporate_rate.currcurrencyversion,
        original_rate.currcurrencyversion) AS corporate_rate_currcurrencyversion,
    COALESCE(corporate_rate.currencyname, original_rate.currencyname) AS
        corporate_rate_currencyname,
    COALESCE(original_rate.cost, corporate_rate.cost) AS original_rate_cost,
    COALESCE(original_rate.cost_national_currency,
        corporate_rate.cost_national_currency) AS
        original_rate_cost_national_currency,
    COALESCE(original_rate.cost_usd_currency,
        corporate_rate.cost_usd_currency) AS original_rate_cost_usd_currency,
    COALESCE(original_rate.usdcurrencysign, corporate_rate.usdcurrencysign)
        AS original_rate_cost_usdcurrencysign,
    COALESCE(original_rate.currcurrencyid, corporate_rate.currcurrencyid)
        AS original_rate_currcurrencyid,
    COALESCE(original_rate.currcurrencyversion,
        corporate_rate.currcurrencyversion) AS original_rate_currcurrencyversion,
    COALESCE(original_rate.currencyname, corporate_rate.currencyname) AS
        original_rate_currencyname
FROM (shop_room_tarriff_original_rate_view original_rate
     FULL JOIN shop_room_tarriff_corporate_rate_view corporate_rate ON
         (((original_rate.room_id = corporate_rate.room_id) AND
         (original_rate.humannumber = corporate_rate.humannumber))));

--
-- Definition for view shop_room_view (OID = 81225) : 
--
CREATE VIEW public.shop_room_view AS
SELECT serv_hotel_room.id,
    serv_hotel_room.version,
    serv_hotel_room.createdby,
    serv_hotel_room.createon,
    serv_hotel_room.firmid AS firm,
    serv_hotel_room.lastmodifiedby,
    serv_hotel_room.modifyon,
    serv_hotel_room.serieskey,
    serv_hotel_room.label,
    serv_hotel_room.breakfast,
    serv_hotel_room.descr,
    serv_hotel_room.guest_number AS guestnumber,
    serv_hotel_room.room_number AS roomnumber,
    dict_global1.dict_value AS dictglobalbyroomtype,
    dict_global1.id AS dictglobalbyroomtypeid,
    serv_hotel3.label AS servhotel,
    serv_hotel3.id AS servhotelid,
    serv_hotel3.version AS servhotelversion,
    COALESCE(rel_image.image, 'static_default.jpg'::text) AS image,
    COALESCE(simple_tariff.cost, (1)::numeric) AS cost
FROM ((((serv_hotel_room
     LEFT JOIN dict_global dict_global1 ON ((serv_hotel_room.room_type_id =
         dict_global1.id)))
     LEFT JOIN serv_hotel serv_hotel3 ON ((serv_hotel_room.hotel_id =
         serv_hotel3.id)))
     LEFT JOIN rel_serv_hotel_room_image_simple_view rel_image ON
         ((serv_hotel_room.id = rel_image.serv_hotel_room_id)))
     LEFT JOIN payment_tariff_shop_simple_view simple_tariff ON
         ((serv_hotel_room.shop_tarriff_id = simple_tariff.id)));

--
-- Definition for view serv_hotel_simple_view (OID = 81230) : 
--
CREATE VIEW public.serv_hotel_simple_view AS
SELECT DISTINCT ON (serv_hotel.id) serv_hotel.id,
    serv_hotel.firmid,
    serv_hotel.modifyon,
    serv_hotel.label,
    serv_hotel.condition_text,
    serv_hotel.descr,
    serv_hotel.synopsis,
    serv_hotel.favorite,
    serv_hotel.freesale,
    serv_hotel.showonline,
    serv_hotel.starcount,
    serv_hotel.timedeparture,
    serv_hotel.timerace,
    serv_hotel.timeearlyrace,
    serv_hotel.timelatedeparture,
    serv_hotel.locationcities_id,
    serv_hotel.locationcountries_id,
    serv_hotel.address_id,
    payment_tariff_shop_simple_view.price,
    payment_tariff_shop_simple_view.humannumber,
    payment_tariff_shop_simple_view.cost
FROM ((serv_hotel
     JOIN serv_hotel_room ON ((serv_hotel.id = serv_hotel_room.hotel_id)))
     JOIN payment_tariff_shop_simple_view ON
         ((serv_hotel_room.shop_tarriff_id = payment_tariff_shop_simple_view.id)))
ORDER BY serv_hotel.id, serv_hotel.starcount DESC, serv_hotel.modifyon
    DESC, payment_tariff_shop_simple_view.price;

--
-- Definition for view shop_hotel_images_view (OID = 81235) : 
--
CREATE VIEW public.shop_hotel_images_view AS
SELECT rel_serv_hotel_image.serv_hotel_id,
    tm_image.id,
    tm_image.createdby,
    tm_image.createon,
    tm_image.firmid,
    tm_image.lastmodifiedby,
    tm_image.modifyon,
    tm_image.serieskey,
    tm_image.version,
    tm_image.contenttype,
    tm_image.extension,
    tm_image.name,
    tm_image.originalfilename,
    tm_image.path,
    tm_image.size,
    (((tm_image.name)::text || '.'::text) || (tm_image.extension)::text) AS image
FROM (rel_serv_hotel_image
     LEFT JOIN tm_image ON ((rel_serv_hotel_image.image_id = tm_image.id)));

--
-- Definition for view shop_hotel_room_images_view (OID = 81240) : 
--
CREATE VIEW public.shop_hotel_room_images_view AS
SELECT rel_serv_hotel_room_image.serv_hotel_room_id,
    tm_image.id,
    tm_image.createdby,
    tm_image.createon,
    tm_image.firmid,
    tm_image.lastmodifiedby,
    tm_image.modifyon,
    tm_image.serieskey,
    tm_image.version,
    tm_image.contenttype,
    tm_image.extension,
    tm_image.name,
    tm_image.originalfilename,
    tm_image.path,
    tm_image.size,
    (((tm_image.name)::text || '.'::text) || (tm_image.extension)::text) AS image
FROM (rel_serv_hotel_room_image
     LEFT JOIN tm_image ON ((rel_serv_hotel_room_image.image_id = tm_image.id)));

--
-- Definition for view static_geo_location_view (OID = 81245) : 
--
CREATE VIEW public.static_geo_location_view AS
SELECT 'Астана'::text AS name,
    '71.430564'::text AS x,
    '51.128422'::text AS y
UNION
SELECT 'Уральск'::text AS name,
    '51.311356'::text AS x,
    '51.175258'::text AS y
UNION
SELECT 'Актобе'::text AS name,
    '57.086274'::text AS x,
    '50.193153'::text AS y
UNION
SELECT 'Атырау'::text AS name,
    '51.814421'::text AS x,
    '47.015923'::text AS y
UNION
SELECT 'Караганда'::text AS name,
    '72.982026'::text AS x,
    '49.735472'::text AS y
UNION
SELECT 'Петропавловск'::text AS name,
    '68.994162'::text AS x,
    '54.799153'::text AS y
UNION
SELECT 'Балхаш'::text AS name,
    '74.912793'::text AS x,
    '46.814559'::text AS y
UNION
SELECT 'Семей'::text AS name,
    '80.137152'::text AS x,
    '50.330598'::text AS y
UNION
SELECT 'Усть-Каменогорск'::text AS name,
    '82.451563'::text AS x,
    '49.874326'::text AS y
UNION
SELECT 'Актау'::text AS name,
    '51.118137'::text AS x,
    '43.622916'::text AS y
UNION
SELECT 'Павлодар'::text AS name,
    '76.83729'::text AS x,
    '52.174788'::text AS y
UNION
SELECT 'Шымкент'::text AS name,
    '69.505959'::text AS x,
    '42.262842'::text AS y
UNION
SELECT 'Алматы'::text AS name,
    '76.741521'::text AS x,
    '43.038851'::text AS y;

--
-- Definition for view shop_serv_hotel_2_view (OID = 81250) : 
--
CREATE VIEW public.shop_serv_hotel_2_view AS
SELECT data.id,
    data.modifyon,
    data.label,
    data.condition_text,
    data.descr,
    data.synopsis,
    data.favorite,
    data.freesale,
    data.showonline,
    data.starcount,
    data.timedeparture,
    data.timerace,
    data.timeearlyrace,
    data.timelatedeparture,
    data.price,
    data.humannumber,
    data.cost,
    data.cityname,
    data.countryname,
    data.image,
    data.currencyid,
    data.currencyname,
    data.currencysign,
    data.usdcurrencysign,
    data.usdcost,
    data.addressname,
    data.yandexmappointx,
    data.yandexmappointy
FROM (
    SELECT DISTINCT ON (serv_hotel_simple_view.id) serv_hotel_simple_view.id,
            serv_hotel_simple_view.modifyon,
            serv_hotel_simple_view.label,
            serv_hotel_simple_view.condition_text,
            serv_hotel_simple_view.descr,
            serv_hotel_simple_view.synopsis,
            serv_hotel_simple_view.favorite,
            serv_hotel_simple_view.freesale,
            serv_hotel_simple_view.showonline,
            serv_hotel_simple_view.starcount,
            serv_hotel_simple_view.timedeparture,
            serv_hotel_simple_view.timerace,
            serv_hotel_simple_view.timeearlyrace,
            serv_hotel_simple_view.timelatedeparture,
            serv_hotel_simple_view.price,
            serv_hotel_simple_view.humannumber,
            serv_hotel_simple_view.cost,
            location_cities_view.cityname,
            location_countries_view.countryname,
            COALESCE(rel_serv_hotel_image_simple_view.image,
                'static_default.jpg'::text) AS image,
            curr_currency_view.id AS currencyid,
            curr_currency_view.nameru AS currencyname,
            '?'::text AS currencysign,
            '$'::text AS usdcurrencysign,
            round((COALESCE(serv_hotel_simple_view.cost, (1)::numeric) /
                (COALESCE(usd_currency.course, 1))::numeric)) AS usdcost,
            COALESCE(location_address_view.label,
                (static_geo_location_view.name)::character varying) AS addressname,
            COALESCE(location_address_view.yandexmappointx,
                (static_geo_location_view.x)::character varying) AS
                yandexmappointx,
            COALESCE(location_address_view.yandexmappointy,
                (static_geo_location_view.y)::character varying) AS yandexmappointy
    FROM (((((((serv_hotel_simple_view
             LEFT JOIN location_cities_view ON
                 ((serv_hotel_simple_view.locationcities_id =
                 location_cities_view.id)))
             LEFT JOIN location_countries_view ON
                 ((serv_hotel_simple_view.locationcountries_id =
                 location_countries_view.id)))
             LEFT JOIN rel_serv_hotel_image_simple_view ON
                 ((serv_hotel_simple_view.id =
                 rel_serv_hotel_image_simple_view.serv_hotel_id)))
             LEFT JOIN curr_currency curr_currency_view ON
                 (((serv_hotel_simple_view.firmid =
                 curr_currency_view.firmid) AND
                 ((curr_currency_view.iso_code)::text = 'KZT'::text))))
             LEFT JOIN curr_currency usd_currency ON
                 (((serv_hotel_simple_view.firmid = usd_currency.firmid)
                 AND ((usd_currency.iso_code)::text = 'USD'::text))))
             LEFT JOIN location_address_view ON
                 ((serv_hotel_simple_view.address_id = location_address_view.id)))
             LEFT JOIN static_geo_location_view ON
                 (((location_cities_view.cityname)::text =
                 static_geo_location_view.name)))
    WHERE (serv_hotel_simple_view.showonline = true)
    ORDER BY serv_hotel_simple_view.id DESC
    ) data
ORDER BY data.cityname, data.starcount DESC, data.cost, data.modifyon DESC;

--
-- Definition for view mail_notebook_view (OID = 81275) : 
--
CREATE VIEW public.mail_notebook_view AS
SELECT DISTINCT ON (data.email) data.id,
    data.objectid,
    data.name,
    data.email,
    data.firm
FROM (
    SELECT md5(((tm_contact_easy.id)::text || 'tm_contact_easy'::text)) AS id,
            tm_contact_easy.id AS objectid,
            tm_contact_easy.label AS name,
            tm_contact_easy.email,
            tm_contact_easy.firmid AS firm
    FROM tm_contact_easy
    UNION ALL
    SELECT md5(((serv_hotel.id)::text || 'serv_hotel'::text)) AS id,
            serv_hotel.id AS objectid,
            serv_hotel.label AS name,
            info_contact_information.email,
            serv_hotel.firmid AS firm
    FROM (serv_hotel
             JOIN info_contact_information ON
                 ((serv_hotel.contactinformation_id =
                 info_contact_information.id)))
    UNION ALL
    SELECT md5(((tm_mail_newsletter_group.id)::text ||
        'tm_mail_newsletter_group'::text)) AS id,
            tm_mail_newsletter_group.id AS objectid,
            tm_mail_newsletter_group.name,
            tm_mail_newsletter_group.email,
            tm_mail_newsletter_group.firmid AS firm
    FROM tm_mail_newsletter_group
    ) data
WHERE (data.email IS NOT NULL);

--
-- Definition for index curr_course_pkey (OID = 78680) : 
--
ALTER TABLE ONLY curr_course
    ADD CONSTRAINT curr_course_pkey
    PRIMARY KEY (id);
--
-- Definition for index curr_currency_pkey (OID = 78682) : 
--
ALTER TABLE ONLY curr_currency
    ADD CONSTRAINT curr_currency_pkey
    PRIMARY KEY (id);
--
-- Definition for index dict_global_pkey (OID = 78684) : 
--
ALTER TABLE ONLY dict_global
    ADD CONSTRAINT dict_global_pkey
    PRIMARY KEY (id);
--
-- Definition for index doc_documents_pkey (OID = 78686) : 
--
ALTER TABLE ONLY doc_documents
    ADD CONSTRAINT doc_documents_pkey
    PRIMARY KEY (id);
--
-- Definition for index info_contact_information_pkey (OID = 78688) : 
--
ALTER TABLE ONLY info_contact_information
    ADD CONSTRAINT info_contact_information_pkey
    PRIMARY KEY (id);
--
-- Definition for index location_address_pkey (OID = 78690) : 
--
ALTER TABLE ONLY location_address
    ADD CONSTRAINT location_address_pkey
    PRIMARY KEY (id);
--
-- Definition for index location_cities_pkey (OID = 78692) : 
--
ALTER TABLE ONLY location_cities
    ADD CONSTRAINT location_cities_pkey
    PRIMARY KEY (id);
--
-- Definition for index location_countries_pkey (OID = 78694) : 
--
ALTER TABLE ONLY location_countries
    ADD CONSTRAINT location_countries_pkey
    PRIMARY KEY (id);
--
-- Definition for index payment_details_pkey (OID = 78696) : 
--
ALTER TABLE ONLY payment_details
    ADD CONSTRAINT payment_details_pkey
    PRIMARY KEY (id);
--
-- Definition for index payment_price_pkey (OID = 78698) : 
--
ALTER TABLE ONLY payment_price
    ADD CONSTRAINT payment_price_pkey
    PRIMARY KEY (id);
--
-- Definition for index payment_tariff_pkey (OID = 78700) : 
--
ALTER TABLE ONLY payment_tariff
    ADD CONSTRAINT payment_tariff_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_serv_hotel_doc_documents_pkey (OID = 78702) : 
--
ALTER TABLE ONLY rel_serv_hotel_doc_documents
    ADD CONSTRAINT rel_serv_hotel_doc_documents_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_serv_hotel_image_pkey (OID = 78704) : 
--
ALTER TABLE ONLY rel_serv_hotel_image
    ADD CONSTRAINT rel_serv_hotel_image_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_serv_hotel_room_image_pkey (OID = 78706) : 
--
ALTER TABLE ONLY rel_serv_hotel_room_image
    ADD CONSTRAINT rel_serv_hotel_room_image_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_serv_transfer_tm_contact_pkey (OID = 78708) : 
--
ALTER TABLE ONLY rel_serv_transfer_tm_contact
    ADD CONSTRAINT rel_serv_transfer_tm_contact_pkey
    PRIMARY KEY (id);
--
-- Definition for index req_serv_hotel_pkey (OID = 78710) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT req_serv_hotel_pkey
    PRIMARY KEY (id);
--
-- Definition for index serv_hotel_pkey (OID = 78712) : 
--
ALTER TABLE ONLY serv_hotel
    ADD CONSTRAINT serv_hotel_pkey
    PRIMARY KEY (id);
--
-- Definition for index serv_hotel_room_pkey (OID = 78714) : 
--
ALTER TABLE ONLY serv_hotel_room
    ADD CONSTRAINT serv_hotel_room_pkey
    PRIMARY KEY (id);
--
-- Definition for index serv_transfer_pkey (OID = 78716) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT serv_transfer_pkey
    PRIMARY KEY (id);
--
-- Definition for index serv_transfer_route_pkey (OID = 78718) : 
--
ALTER TABLE ONLY serv_transfer_route
    ADD CONSTRAINT serv_transfer_route_pkey
    PRIMARY KEY (id);
--
-- Definition for index serv_transfer_route_point_pkey (OID = 78720) : 
--
ALTER TABLE ONLY serv_transfer_route_point
    ADD CONSTRAINT serv_transfer_route_point_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_account_pkey (OID = 78722) : 
--
ALTER TABLE ONLY tm_account
    ADD CONSTRAINT tm_account_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_contact_pkey (OID = 78724) : 
--
ALTER TABLE ONLY tm_contact
    ADD CONSTRAINT tm_contact_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_contact_easy_pkey (OID = 78726) : 
--
ALTER TABLE ONLY tm_contact_easy
    ADD CONSTRAINT tm_contact_easy_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_firms_pkey (OID = 78728) : 
--
ALTER TABLE ONLY tm_firms
    ADD CONSTRAINT tm_firms_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_image_pkey (OID = 78730) : 
--
ALTER TABLE ONLY tm_image
    ADD CONSTRAINT tm_image_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_user_info_pkey (OID = 78732) : 
--
ALTER TABLE ONLY tm_user_info
    ADD CONSTRAINT tm_user_info_pkey
    PRIMARY KEY (id);
--
-- Definition for index user_roles_pkey (OID = 78734) : 
--
ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey
    PRIMARY KEY (id);
--
-- Definition for index users_pkey (OID = 78736) : 
--
ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey
    PRIMARY KEY (id);
--
-- Definition for index uk_r43af9ap4edm43mmtq01oddj6 (OID = 78738) : 
--
ALTER TABLE ONLY users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6
    UNIQUE (username);
--
-- Definition for index fk_qet8yum4olo8f9ek4xl4m5sbk (OID = 78740) : 
--
ALTER TABLE ONLY location_cities
    ADD CONSTRAINT fk_qet8yum4olo8f9ek4xl4m5sbk
    FOREIGN KEY (countryid) REFERENCES location_countries(id);
--
-- Definition for index fk_qy0snarm50d1jp2oi5ba9yy4n (OID = 78745) : 
--
ALTER TABLE ONLY payment_price
    ADD CONSTRAINT fk_qy0snarm50d1jp2oi5ba9yy4n
    FOREIGN KEY (payment_tariff_id) REFERENCES payment_tariff(id);
--
-- Definition for index fk_l8sd9q4pwlusrhbxbp6k1xt4a (OID = 78750) : 
--
ALTER TABLE ONLY rel_serv_hotel_doc_documents
    ADD CONSTRAINT fk_l8sd9q4pwlusrhbxbp6k1xt4a
    FOREIGN KEY (doc_documents_id) REFERENCES doc_documents(id);
--
-- Definition for index fk_lcuc2amgag6r1r7x8347m98ba (OID = 78755) : 
--
ALTER TABLE ONLY rel_serv_hotel_doc_documents
    ADD CONSTRAINT fk_lcuc2amgag6r1r7x8347m98ba
    FOREIGN KEY (serv_hotel_id) REFERENCES serv_hotel(id);
--
-- Definition for index fk_67uic74ed1lvltqno6jk1nol (OID = 78760) : 
--
ALTER TABLE ONLY rel_serv_hotel_image
    ADD CONSTRAINT fk_67uic74ed1lvltqno6jk1nol
    FOREIGN KEY (serv_hotel_id) REFERENCES serv_hotel(id);
--
-- Definition for index fk_qi9x94lihwok47f20xvtbwfuj (OID = 78765) : 
--
ALTER TABLE ONLY rel_serv_hotel_image
    ADD CONSTRAINT fk_qi9x94lihwok47f20xvtbwfuj
    FOREIGN KEY (image_id) REFERENCES tm_image(id);
--
-- Definition for index fk_rh5od1sedqm18bf2qamxh6qpp (OID = 78770) : 
--
ALTER TABLE ONLY rel_serv_hotel_room_image
    ADD CONSTRAINT fk_rh5od1sedqm18bf2qamxh6qpp
    FOREIGN KEY (serv_hotel_room_id) REFERENCES serv_hotel_room(id);
--
-- Definition for index fk_qb6jghh8e6fa0subj4h8l8oub (OID = 78775) : 
--
ALTER TABLE ONLY rel_serv_hotel_room_image
    ADD CONSTRAINT fk_qb6jghh8e6fa0subj4h8l8oub
    FOREIGN KEY (image_id) REFERENCES tm_image(id);
--
-- Definition for index fk_e49tcg2ew4x23qsw55c8f7y0u (OID = 78780) : 
--
ALTER TABLE ONLY rel_serv_transfer_tm_contact
    ADD CONSTRAINT fk_e49tcg2ew4x23qsw55c8f7y0u
    FOREIGN KEY (serv_transfers_id) REFERENCES serv_transfer(id);
--
-- Definition for index fk_dyn7syqnpxyo0qwuqmhbaj3rv (OID = 78785) : 
--
ALTER TABLE ONLY rel_serv_transfer_tm_contact
    ADD CONSTRAINT fk_dyn7syqnpxyo0qwuqmhbaj3rv
    FOREIGN KEY (tm_contact_id) REFERENCES tm_contact(id);
--
-- Definition for index fk_bgw2mgwqqsr9bwl236wdsbq16 (OID = 78790) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_bgw2mgwqqsr9bwl236wdsbq16
    FOREIGN KEY (document_for_hotel_id) REFERENCES doc_documents(id);
--
-- Definition for index fk_5gwh69rll0l546i0coqwj0ba5 (OID = 78795) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_5gwh69rll0l546i0coqwj0ba5
    FOREIGN KEY (document_for_user_id) REFERENCES doc_documents(id);
--
-- Definition for index fk_m2ekm8mkhbva75c9wyqi91ut9 (OID = 78800) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_m2ekm8mkhbva75c9wyqi91ut9
    FOREIGN KEY (payment_price_id) REFERENCES payment_price(id);
--
-- Definition for index fk_o9ajlfdbb1whgr8h94dp8hydg (OID = 78805) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_o9ajlfdbb1whgr8h94dp8hydg
    FOREIGN KEY (payment_tariff_id) REFERENCES payment_tariff(id);
--
-- Definition for index fk_2jt2q7ir1e0gdb72dcj4wpwif (OID = 78810) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_2jt2q7ir1e0gdb72dcj4wpwif
    FOREIGN KEY (serv_hotel_id) REFERENCES serv_hotel(id);
--
-- Definition for index fk_2yaqr6ncyer3bwog5xg8fw72m (OID = 78815) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_2yaqr6ncyer3bwog5xg8fw72m
    FOREIGN KEY (serv_hotel_room_id) REFERENCES serv_hotel_room(id);
--
-- Definition for index fk_1e0jxsjumdiyoduig4svygkhw (OID = 78820) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_1e0jxsjumdiyoduig4svygkhw
    FOREIGN KEY (request_user_id) REFERENCES users(id);
--
-- Definition for index fk_rm0ybefxrgykm0js17tes8a81 (OID = 78825) : 
--
ALTER TABLE ONLY req_serv_hotel
    ADD CONSTRAINT fk_rm0ybefxrgykm0js17tes8a81
    FOREIGN KEY (response_user_id) REFERENCES users(id);
--
-- Definition for index fk_d6sym7mj137o1f7hpbctjjs92 (OID = 78830) : 
--
ALTER TABLE ONLY serv_hotel
    ADD CONSTRAINT fk_d6sym7mj137o1f7hpbctjjs92
    FOREIGN KEY (contactinformation_id) REFERENCES info_contact_information(id);
--
-- Definition for index fk_okvswyj2x26xswoeiy9gx6ojd (OID = 78835) : 
--
ALTER TABLE ONLY serv_hotel
    ADD CONSTRAINT fk_okvswyj2x26xswoeiy9gx6ojd
    FOREIGN KEY (address_id) REFERENCES location_address(id);
--
-- Definition for index fk_1r1r4iluqagfqybh6cud7kd92 (OID = 78840) : 
--
ALTER TABLE ONLY serv_hotel
    ADD CONSTRAINT fk_1r1r4iluqagfqybh6cud7kd92
    FOREIGN KEY (locationcities_id) REFERENCES location_cities(id);
--
-- Definition for index fk_1dgwpsl5gvh8q16rm8mkxhc34 (OID = 78845) : 
--
ALTER TABLE ONLY serv_hotel
    ADD CONSTRAINT fk_1dgwpsl5gvh8q16rm8mkxhc34
    FOREIGN KEY (locationcountries_id) REFERENCES location_countries(id);
--
-- Definition for index fk_2pgwsg699swunbp1ipf49l0f5 (OID = 78850) : 
--
ALTER TABLE ONLY serv_hotel
    ADD CONSTRAINT fk_2pgwsg699swunbp1ipf49l0f5
    FOREIGN KEY (payment_details_id) REFERENCES payment_details(id);
--
-- Definition for index fk_48ot1btd709cvhmkwuhtwvstc (OID = 78855) : 
--
ALTER TABLE ONLY serv_hotel_room
    ADD CONSTRAINT fk_48ot1btd709cvhmkwuhtwvstc
    FOREIGN KEY (room_type_id) REFERENCES dict_global(id);
--
-- Definition for index fk_s56n01uxkjmww661pceaojkh9 (OID = 78860) : 
--
ALTER TABLE ONLY serv_hotel_room
    ADD CONSTRAINT fk_s56n01uxkjmww661pceaojkh9
    FOREIGN KEY (hotel_id) REFERENCES serv_hotel(id);
--
-- Definition for index fk_m6qk8jlnpdydk5cv866hxmgh9 (OID = 78865) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_m6qk8jlnpdydk5cv866hxmgh9
    FOREIGN KEY (currency_id) REFERENCES curr_currency(id);
--
-- Definition for index fk_ndu7mocie7j76mhc11y407wkk (OID = 78870) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_ndu7mocie7j76mhc11y407wkk
    FOREIGN KEY (payment_type_id) REFERENCES dict_global(id);
--
-- Definition for index fk_6wvbmmo6po3cnvne117ixxgq6 (OID = 78875) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_6wvbmmo6po3cnvne117ixxgq6
    FOREIGN KEY (transport_id) REFERENCES dict_global(id);
--
-- Definition for index fk_b1gemgdgbabmi240qfmonx5sw (OID = 78880) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_b1gemgdgbabmi240qfmonx5sw
    FOREIGN KEY (type_transfer_id) REFERENCES dict_global(id);
--
-- Definition for index fk_iarwftldl95bsp1o1vldkrdh (OID = 78885) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_iarwftldl95bsp1o1vldkrdh
    FOREIGN KEY (location_cities_id) REFERENCES location_cities(id);
--
-- Definition for index fk_5bohx5tf5too6ic6kgphrcxjs (OID = 78890) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_5bohx5tf5too6ic6kgphrcxjs
    FOREIGN KEY (location_countries_id) REFERENCES location_countries(id);
--
-- Definition for index fk_1yn2cmebo4ipe834c1jtepfip (OID = 78895) : 
--
ALTER TABLE ONLY serv_transfer
    ADD CONSTRAINT fk_1yn2cmebo4ipe834c1jtepfip
    FOREIGN KEY (account_id) REFERENCES tm_account(id);
--
-- Definition for index fk_83h9871rihaj6cqpnp6svtfkl (OID = 78900) : 
--
ALTER TABLE ONLY serv_transfer_route
    ADD CONSTRAINT fk_83h9871rihaj6cqpnp6svtfkl
    FOREIGN KEY (currency_id) REFERENCES curr_currency(id);
--
-- Definition for index fk_rwt0vs34sgqg27kt21mvpyqp (OID = 78905) : 
--
ALTER TABLE ONLY serv_transfer_route
    ADD CONSTRAINT fk_rwt0vs34sgqg27kt21mvpyqp
    FOREIGN KEY (serv_transfer_id) REFERENCES serv_transfer(id);
--
-- Definition for index fk_7esvu01myhs2cwvetam5cpy2d (OID = 78910) : 
--
ALTER TABLE ONLY serv_transfer_route_point
    ADD CONSTRAINT fk_7esvu01myhs2cwvetam5cpy2d
    FOREIGN KEY (transfer_route_id) REFERENCES serv_transfer_route(id);
--
-- Definition for index fk_o4y03k3g4jdn6oea2o1wwa74m (OID = 78915) : 
--
ALTER TABLE ONLY tm_account
    ADD CONSTRAINT fk_o4y03k3g4jdn6oea2o1wwa74m
    FOREIGN KEY (residency_id) REFERENCES location_countries(id);
--
-- Definition for index fk_rfw3lprqrxkojs1owre3mi7ww (OID = 78920) : 
--
ALTER TABLE ONLY tm_contact
    ADD CONSTRAINT fk_rfw3lprqrxkojs1owre3mi7ww
    FOREIGN KEY (citizenship_id) REFERENCES location_countries(id);
--
-- Definition for index fk_tdka1uukt8pqq7ym215avct5a (OID = 78925) : 
--
ALTER TABLE ONLY tm_contact_easy
    ADD CONSTRAINT fk_tdka1uukt8pqq7ym215avct5a
    FOREIGN KEY (country_id) REFERENCES location_countries(id);
--
-- Definition for index fk_g1uebn6mqk9qiaw45vnacmyo2 (OID = 78930) : 
--
ALTER TABLE ONLY user_roles
    ADD CONSTRAINT fk_g1uebn6mqk9qiaw45vnacmyo2
    FOREIGN KEY (user_id) REFERENCES users(id);
--
-- Definition for index fk_94dj9ry3k3tmcsyg8eatp7vvn (OID = 78935) : 
--
ALTER TABLE ONLY users
    ADD CONSTRAINT fk_94dj9ry3k3tmcsyg8eatp7vvn
    FOREIGN KEY (image_id) REFERENCES tm_image(id);
--
-- Definition for index serv_hotel_room_fk1 (OID = 78940) : 
--
ALTER TABLE ONLY serv_hotel_room
    ADD CONSTRAINT serv_hotel_room_fk1
    FOREIGN KEY (cost_tarriff_id) REFERENCES payment_tariff(id);
--
-- Definition for index tm_contact_easy_fk (OID = 78945) : 
--
ALTER TABLE ONLY tm_contact_easy
    ADD CONSTRAINT tm_contact_easy_fk
    FOREIGN KEY (req_serv_hotel_id) REFERENCES req_serv_hotel(id);
--
-- Definition for index serv_hotel_room_fk2 (OID = 78950) : 
--
ALTER TABLE ONLY serv_hotel_room
    ADD CONSTRAINT serv_hotel_room_fk2
    FOREIGN KEY (rr_tarriff_id) REFERENCES payment_tariff(id);
--
-- Definition for index firm_settings_pkey (OID = 78955) : 
--
ALTER TABLE ONLY tm_firm_settings
    ADD CONSTRAINT firm_settings_pkey
    PRIMARY KEY (id);
--
-- Definition for index payment_tariff_shop_pkey (OID = 78957) : 
--
ALTER TABLE ONLY payment_tariff_shop
    ADD CONSTRAINT payment_tariff_shop_pkey
    PRIMARY KEY (id);
--
-- Definition for index serv_hotel_room_fk (OID = 78959) : 
--
ALTER TABLE ONLY serv_hotel_room
    ADD CONSTRAINT serv_hotel_room_fk
    FOREIGN KEY (shop_tarriff_id) REFERENCES payment_tariff_shop(id) MATCH FULL;
--
-- Definition for index tm_firm_settings_fk (OID = 78964) : 
--
ALTER TABLE ONLY tm_firm_settings
    ADD CONSTRAINT tm_firm_settings_fk
    FOREIGN KEY (doc_documents_id) REFERENCES doc_documents(id);
--
-- Definition for index payment_price_shop_pkey (OID = 78969) : 
--
ALTER TABLE ONLY payment_price_shop
    ADD CONSTRAINT payment_price_shop_pkey
    PRIMARY KEY (id);
--
-- Definition for index payment_price_shop_fk (OID = 78971) : 
--
ALTER TABLE ONLY payment_price_shop
    ADD CONSTRAINT payment_price_shop_fk
    FOREIGN KEY (payment_tariff_shop_id) REFERENCES payment_tariff_shop(id);
--
-- Definition for index shop_user_pkey (OID = 79688) : 
--
ALTER TABLE ONLY shop_user
    ADD CONSTRAINT shop_user_pkey
    PRIMARY KEY (id);
--
-- Definition for index shop_user_username_key (OID = 79690) : 
--
ALTER TABLE ONLY shop_user
    ADD CONSTRAINT shop_user_username_key
    UNIQUE (username);
--
-- Definition for index shop_permission_pkey (OID = 79695) : 
--
ALTER TABLE ONLY shop_permission
    ADD CONSTRAINT shop_permission_pkey
    PRIMARY KEY (id);
--
-- Definition for index info_permission_pkey (OID = 79703) : 
--
ALTER TABLE ONLY info_permission
    ADD CONSTRAINT info_permission_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_shop_permission_pkey (OID = 79708) : 
--
ALTER TABLE ONLY rel_shop_permission
    ADD CONSTRAINT rel_shop_permission_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_shop_permission_fk (OID = 79710) : 
--
ALTER TABLE ONLY rel_shop_permission
    ADD CONSTRAINT rel_shop_permission_fk
    FOREIGN KEY (shop_permission_id) REFERENCES shop_permission(id);
--
-- Definition for index rel_shop_permission_fk1 (OID = 79715) : 
--
ALTER TABLE ONLY rel_shop_permission
    ADD CONSTRAINT rel_shop_permission_fk1
    FOREIGN KEY (info_permission_id) REFERENCES info_permission(id);
--
-- Definition for index info_permission_fk (OID = 79720) : 
--
ALTER TABLE ONLY info_permission
    ADD CONSTRAINT info_permission_fk
    FOREIGN KEY (doc_document_id) REFERENCES doc_documents(id);
--
-- Definition for index user_details_pkey (OID = 80313) : 
--
ALTER TABLE ONLY user_detail
    ADD CONSTRAINT user_details_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_user_details_pkey (OID = 80318) : 
--
ALTER TABLE ONLY rel_user_details
    ADD CONSTRAINT rel_user_details_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_user_details_fk (OID = 80320) : 
--
ALTER TABLE ONLY rel_user_details
    ADD CONSTRAINT rel_user_details_fk
    FOREIGN KEY (user_details_id) REFERENCES user_detail(id);
--
-- Definition for index rel_user_details_fk1 (OID = 80325) : 
--
ALTER TABLE ONLY rel_user_details
    ADD CONSTRAINT rel_user_details_fk1
    FOREIGN KEY (users_id) REFERENCES users(id);
--
-- Definition for index tm_mail_newsletter_pkey (OID = 80951) : 
--
ALTER TABLE ONLY tm_mail_newsletter
    ADD CONSTRAINT tm_mail_newsletter_pkey
    PRIMARY KEY (id);
--
-- Definition for index tm_mail_newsletter_group_pkey (OID = 80959) : 
--
ALTER TABLE ONLY tm_mail_newsletter_group
    ADD CONSTRAINT tm_mail_newsletter_group_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_mail_newsletter_group_pkey (OID = 80964) : 
--
ALTER TABLE ONLY rel_mail_newsletter_group
    ADD CONSTRAINT rel_mail_newsletter_group_pkey
    PRIMARY KEY (id);
--
-- Definition for index rel_mail_newsletter_group_fk (OID = 80966) : 
--
ALTER TABLE ONLY rel_mail_newsletter_group
    ADD CONSTRAINT rel_mail_newsletter_group_fk
    FOREIGN KEY (tm_mail_newsletter_id) REFERENCES tm_mail_newsletter(id);
--
-- Definition for index rel_mail_newsletter_group_fk1 (OID = 80971) : 
--
ALTER TABLE ONLY rel_mail_newsletter_group
    ADD CONSTRAINT rel_mail_newsletter_group_fk1
    FOREIGN KEY (tm_mail_newsletter_group_id) REFERENCES tm_mail_newsletter_group(id);
--
-- Comments
--
COMMENT ON SCHEMA public IS 'standard public schema';
COMMENT ON TABLE public.tm_firm_settings IS 'SObject table';
