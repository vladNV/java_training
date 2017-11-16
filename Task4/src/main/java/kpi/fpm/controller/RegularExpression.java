/*
 *  RegularExpression
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.controller;

/**
 * The interface, set of regular expressions.
 */
public interface RegularExpression {

    // first name, surname, second name.
    String REGEXP_NAME = "^[A-Z][a-z\\-]{2,100}$";
    // login
    String REGEXP_LOGIN = "^[A-Za-z0-9_]{3,100}$";
    // skype
    String REGEXP_SKYPE = "^[A-Za-z0-9]{3,75}$";
    String REGEXP_COMMENT = "^[A-Za-z_\\-,\\.:;\\s\"'!\\?]{0,1000}$";
    String REGEXP_MOBILE_NUMBER_UA = "^\\+?(38)*0[1-9]{1}\\d{1}(\\-?)(\\d{2}|\\d{3})\\-?\\d{2}\\-?(\\d{2}|\\d{3})$";
    String REGEXP_MOBILE_NUMBER_USA = "^((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}$";
    String REGEXP_EMAIL = "[a-z0-9\\.]{3,40}@[a-z]{1,7}\\.[a-z]{2,3}";
    String REGEXP_CONTACT_GROUP = "(Coworker|Friend|Relative|Colleague|Other)";
    String REGEXP_NUMBER = "^[0-9]{0,8}$";
    String REGEXP_ADDRESS = "^+[A-Za-z\\-,\\.\\s]{3,250}";
    String REGEXP_NUM_HOUSE = "^[0-9]{1,4}([A-Za-z]{0,2}|/[0-9]{1,4}[A-Za-z]{0,2})$";
    String REGEXP_CITY = "[A-Za-z\\-\\s]{2,200}";



}
