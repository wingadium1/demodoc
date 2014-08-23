package mhst.dreamteam.Icinga;

/**
 * Icinga api constants
 * Created by mk on 12/08/2014.
 */
public class IcingaApiConst {

    ////////////////////////////////// ICINGA API CONST //////////////////////////////////////
    public static final String CONNECTION_IDO = "Ido";
    public static final String CONNECTION_IDO_ABSTRACTION = "IdoAbstraction";
    public static final String CONNECTION_FILE = "File";
    public static final String CONNECTION_LIVESTATUS = "Livestatus";

    // CONTACT SOURCES
    public static final String CONTACT_SOURCE_PHP_AUTH_USER = "PHP_AUTH_USER";

    // DEBUGGING
    public static final String DEBUG_OVERALL_TIME = "overall time";
    public static final int DEBUG_LEVEL_ALL = 0xff;
    public static final int DEBUG_LEVEL_ERROR = 0x01;
    public static final int DEBUG_LEVEL_WARNING = 0x02;
    public static final int DEBUG_LEVEL_DEBUG = 0x08;

    // FILE SOURCES
    public static final String FILE_OBJECTS = "objects";
    public static final String FILE_RETENTION = "retention";
    public static final String FILE_STATUS = "status";

    // TARGET TYPES
    public static final String TARGET_INSTANCE = "instance";
    public static final String TARGET_HOST = "host";
    public static final String TARGET_SERVICE = "service";
    public static final String TARGET_HOSTGROUP = "hostgroup";
    public static final String TARGET_SERVICEGROUP = "servicegroup";
    public static final String TARGET_CONTACT = "contact";
    public static final String TARGET_CONTACTGROUP = "contactgroup";
    public static final String TARGET_TIMEPERIOD = "timeperiod";
    public static final String TARGET_HOSTSTATUS = "hoststatus";
    public static final String TARGET_SERVICESTATUS = "servicestatus";
    public static final String TARGET_CUSTOMVARIABLE = "customvariable";
    public static final String TARGET_HOST_TIMES = "hosttimes";
    public static final String TARGET_SERVICE_TIMES = "servicetimes";
    public static final String TARGET_CONFIG = "config";
    public static final String TARGET_PROGRAM = "program";
    public static final String TARGET_LOG = "log";
    public static final String TARGET_HOST_STATUS_SUMMARY = "host_status_summary";
    public static final String TARGET_SERVICE_STATUS_SUMMARY = "service_status_summary";
    public static final String TARGET_HOST_STATUS_SUMMARY_STRICT = "host_status_summary_strict";
    public static final String TARGET_SERVICE_STATUS_SUMMARY_STRICT = "service_status_summary_strict";
    public static final String TARGET_HOST_STATUS_HISTORY = "host_status_history";
    public static final String TARGET_SERVICE_STATUS_HISTORY = "service_status_history";
    public static final String TARGET_HOST_PARENTS = "host_parents";
    public static final String TARGET_NOTIFICATIONS = "notifications";
    public static final String TARGET_HOSTGROUP_SUMMARY = "hostgroup_summary";
    public static final String TARGET_SERVICEGROUP_SUMMARY = "servicegroup_summary";
    public static final String TARGET_COMMAND = "command";   // livestatus only
    public static final String TARGET_DOWNTIME = "downtime";
    public static final String TARGET_DOWNTIMEHISTORY = "downtimehistory";
    public static final String TARGET_COMMENT = "comment";
    public static final String TARGET_HOST_COMMENT = "hostcomment";
    public static final String TARGET_SERVICE_COMMENT = "servicecomment";
    public static final String TARGET_STATUS = "status";     // livestatus only
    public static final String TARGET_HOST_SERVICE = "host_service";
    // SEARCH TYPES
    public static final String SEARCH_TYPE_COUNT = "count";

    // SEARCH AGGREGATORS
    public static final String SEARCH_OR = "or";
    public static final String SEARCH_AND = "and";

    // MATCH TYPES
    public static final String MATCH_EXACT = "=";
    public static final String MATCH_NOT_EQUAL = "!=";
    public static final String MATCH_LIKE = "like";
    public static final String MATCH_NOT_LIKE = "not like";
    public static final String MATCH_GREATER_THAN = ">";
    public static final String MATCH_GREATER_OR_EQUAL = ">=";
    public static final String MATCH_LESS_THAN = "<";
    public static final String MATCH_LESS_OR_EQUAL = "<=";

    // RESULT TYPES
    public static final String RESULT_OBJECT = "object";
    public static final String RESULT_ARRAY = "array";

    // HOST STATES
    public static final int HOST_STATE_OK = 0;
    public static final int HOST_STATE_UNREACHABLE = 2;
    public static final int HOST_STATE_DOWN = 1;

    // SERVICE STATES
    public static final int SERVICE_STATE_OK = 0;
    public static final int SERVICE_STATE_WARNING = 1;
    public static final int SERVICE_STATE_CRITICAL = 2;
    public static final int SERVICE_STATE_UNKNOWN = 3;

    // COMMAND INTERFACES
    public static final String COMMAND_PIPE = "Pipe";
    public static final String COMMAND_SSH = "Ssh";

    // COMMAND FIELDS
    public static final String COMMAND_INSTANCE = "instance";
    public static final String COMMAND_HOSTGROUP = "hostgroup";
    public static final String COMMAND_SERVICEGROUP = "servicegroup";
    public static final String COMMAND_HOST = "host";
    public static final String COMMAND_SERVICE = "service";
    public static final String COMMAND_ID = "id";
    public static final String COMMAND_AUTHOR = "author";
    public static final String COMMAND_COMMENT = "comment";
    public static final String COMMAND_STARTTIME = "starttime";
    public static final String COMMAND_ENDTIME = "endtime";
    public static final String COMMAND_STICKY = "sticky";
    public static final String COMMAND_PERSISTENT = "persistent";
    public static final String COMMAND_NOTIFY = "notify";
    public static final String COMMAND_RETURN_CODE = "return_code";
    public static final String COMMAND_CHECKTIME = "checktime";
    public static final String COMMAND_FIXED = "fixed";
    public static final String COMMAND_OUTPUT = "output";
    public static final String COMMAND_PERFDATA = "perfdata";
    public static final String COMMAND_DURATION = "duration";
    public static final String COMMAND_DATA = "data";
    public static final String COMMAND_NOTIFICATION_OPTIONS = "notification_options";
    public static final String COMMAND_DOWNTIME_ID = "downtime_id";

}
