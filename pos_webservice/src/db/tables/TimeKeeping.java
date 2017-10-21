/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.tables;

/**
 *
 * @author ETDelacruz
 */
public class TimeKeeping {
    
    public static final String ID = "entry_id";
    public static final String USERID = "userid";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String USERNAME = "username";
    public static final String RECORD_TYPE = "record_type";
    public static final String START = "start_time";
    public static final String END = "end_time";
    public static final String REMARKS = "remarks";

    public static final String TABLE_NAME = "timekeeping_{YYMMDD}";
    
    public static final String CREATE_TIMEKEEP_TODAY = "CREATE TABLE IF NOT EXISTS timekeeping_{YYYYMMDD} " +
                   "(entry_id int(11) NOT NULL AUTO_INCREMENT, " +
                   " userid int(11) NOT NULL, " + 
                   " firstname varchar(15) NOT NULL, " + 
                   " lastname varchar(255) NOT NULL, " +
                   " username varchar(50) NOT NULL, " +
                   " record_type enum('job','break') NOT NULL, " +
                   " start_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                   " end_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                   " remarks varchar(255), " +
                   " PRIMARY KEY ( entry_id )"
            + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1";
    
    
    public static final String TIME_IN = "INSERT INTO timekeeping_{YYYYMMDD} (userid, firstname, lastname, username, record_type) VALUES (?,?,?,?,?)";
    public static final String TIME_OUT = "UPDATE timekeeping_{YYYYMMDD} set remarks = ? where entry_id = ? and record_type = ?";
    public static final String START_BREAK = "INSERT INTO timekeeping_{YYYYMMDD} (userid, firstname, lastname, username, record_type) VALUES (?,?,?,?,?)";
    public static final String END_BREAK = "UPDATE timekeeping_{YYYYMMDD} set remarks = ? where entry_id = ? and record_type = ?";
    
    public static final String GET_RECORD_TODAY = "SELECT entry_id FROM timekeeping_{YYYYMMDD} where userid = ? and record_type = ?";
    
    //reports
    //public static final String GET_TIMERECORDS_TODAY = "select concat(lastname, ', ',firstname) as 'Employee Name', start_time, end_time, timediff(end_time, start_time )as 'Hours Worked' from timekeeping_{YYYYMMDD}";
    public static final String GET_TIMERECORDS_SPECIFIC_DATE = "select concat(lastname, ', ',firstname) as 'Employee Name', record_type,start_time, end_time, timediff(end_time, start_time )as 'Time Spent (Hours)' from timekeeping_{YYYYMMDD} where date(start_time) between ? and ?";
}
