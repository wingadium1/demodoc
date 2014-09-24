package mhst.dreamteam.IcingaClient.Icinga;

/**
 * Icinga target and filter constants
 *
 * @author MinhNN
 */
public class IcingaConst {

    ////////////////////////////////// ICINGA TARGET & FILTER //////////////////////////////////////
    // Target
    public static final String TARGET_INSTANCE = "instance";
    public static final String TARGET_HOST = "host";
    public static final String TARGET_SERVICE = "service";
    public static final String TARGET_HOSTGROUP = "hostgroup";
    public static final String TARGET_SERVICEGROUP = "servicegroup";
    public static final String TARGET_CONTACT = "contact";
    public static final String TARGET_CONTACTGROUP = "contactgroup";
    public static final String TARGET_TIMEPERIOD = "timeperiod";
    public static final String TARGET_CUSTOMVARIABLE = "customvariable";
    public static final String TARGET_CONFIG = "config";
    public static final String TARGET_PROGRAM = "program";
    public static final String TARGET_LOG = "log";
    public static final String TARGET_HOST_STATUS_SUMMARY_STRICT = "host_status_summary_strict";
    public static final String TARGET_SERVICE_STATUS_SUMMARY_STRICT = "service_status_summary_strict";
    public static final String TARGET_HOST_STATUS_SUMMARY = "host_status_summary";
    public static final String TARGET_SERVICE_STATUS_SUMMARY = "service_status_summary";
    public static final String TARGET_HOST_STATUS_HISTORY = "host_status_history";
    public static final String TARGET_SERVICE_STATUS_HISTORY = "service_status_history";
    public static final String TARGET_HOST_PARENTS = "host_parents";
    public static final String TARGET_NOTIFICATIONS = "notifications";
    public static final String TARGET_HOSTGROUP_SUMMARY = "hostgroup_summary";
    public static final String TARGET_SERVICEGROUP_SUMMARY = "servicegroup_summary";
    public static final String TARGET_COMMENT = "comment";
    public static final String TARGET_HOST_COMMENT = "host_comment";
    public static final String TARGET_SERVICE_COMMENT = "service_comment";
    public static final String TARGET_HOST_SERVICE = "host_service";
    public static final String TARGET_DOWNTIMEHISTORY = "downtimehistory";
    public static final String TARGET_DOWNTIME = "downtime";

    // Problem
    public static final String PROBLEMS_OBJECT_ID = "PROBLEMS_OBJECT_ID";

    // Program information
    public static final String PROGRAMSTATUS_ID = "PROGRAMSTATUS_ID";
    public static final String PROGRAMSTATUS_INSTANCE_ID = "PROGRAMSTATUS_INSTANCE_ID";
    public static final String PROGRAMSTATUS_STATUS_UPDATE_TIME = "PROGRAMSTATUS_STATUS_UPDATE_TIME";
    public static final String PROGRAMSTATUS_PROGRAM_START_TIME = "PROGRAMSTATUS_PROGRAM_START_TIME";
    public static final String PROGRAMSTATUS_PROGRAM_END_TIME = "PROGRAMSTATUS_PROGRAM_END_TIME";
    public static final String PROGRAMSTATUS_IS_CURRENTLY_RUNNING = "PROGRAMSTATUS_IS_CURRENTLY_RUNNING";
    public static final String PROGRAMSTATUS_PROCESS_ID = "PROGRAMSTATUS_PROCESS_ID";
    public static final String PROGRAMSTATUS_DAEMON_MODE = "PROGRAMSTATUS_DAEMON_MODE";
    public static final String PROGRAMSTATUS_LAST_COMMAND_CHECK = "PROGRAMSTATUS_LAST_COMMAND_CHECK";
    public static final String PROGRAMSTATUS_LAST_LOG_ROTATION = "PROGRAMSTATUS_LAST_LOG_ROTATION";
    public static final String PROGRAMSTATUS_NOTIFICATIONS_ENABLED = "PROGRAMSTATUS_NOTIFICATIONS_ENABLED";
    public static final String PROGRAMSTATUS_ACTIVE_SERVICE_CHECKS_ENABLED = "PROGRAMSTATUS_ACTIVE_SERVICE_CHECKS_ENABLED";
    public static final String PROGRAMSTATUS_PASSIVE_SERVICE_CHECKS_ENABLED = "PROGRAMSTATUS_PASSIVE_SERVICE_CHECKS_ENABLED";
    public static final String PROGRAMSTATUS_ACTIVE_HOST_CHECKS_ENABLED = "PROGRAMSTATUS_ACTIVE_HOST_CHECKS_ENABLED";
    public static final String PROGRAMSTATUS_PASSIVE_HOST_CHECKS_ENABLED = "PROGRAMSTATUS_PASSIVE_HOST_CHECKS_ENABLED";
    public static final String PROGRAMSTATUS_EVENT_HANDLERS_ENABLED = "PROGRAMSTATUS_EVENT_HANDLERS_ENABLED";
    public static final String PROGRAMSTATUS_FLAP_DETECTION_ENABLED = "PROGRAMSTATUS_FLAP_DETECTION_ENABLED";
    public static final String PROGRAMSTATUS_FAILURE_PREDICTION_ENABLED = "PROGRAMSTATUS_FAILURE_PREDICTION_ENABLED";
    public static final String PROGRAMSTATUS_PROCESS_PERFORMANCE_DATA = "PROGRAMSTATUS_PROCESS_PERFORMANCE_DATA";
    public static final String PROGRAMSTATUS_OBSESS_OVER_HOSTS = "PROGRAMSTATUS_OBSESS_OVER_HOSTS";
    public static final String PROGRAMSTATUS_OBSESS_OVER_SERVICES = "PROGRAMSTATUS_OBSESS_OVER_SERVICES";
    public static final String PROGRAMSTATUS_MODIFIED_HOST_ATTRIBUTES = "PROGRAMSTATUS_MODIFIED_HOST_ATTRIBUTES";
    public static final String PROGRAMSTATUS_MODIFIED_SERVICE_ATTRIBUTES = "PROGRAMSTATUS_MODIFIED_SERVICE_ATTRIBUTES";
    public static final String PROGRAMSTATUS_GLOBAL_HOST_EVENT_HANDLER = "PROGRAMSTATUS_GLOBAL_HOST_EVENT_HANDLER";
    public static final String PROGRAMSTATUS_GLOBAL_SERVICE_EVENT_HANDLER = "PROGRAMSTATUS_GLOBAL_SERVICE_EVENT_HANDLER";

    // Instance things
    public static final String INSTANCE_ID = "INSTANCE_ID";
    public static final String INSTANCE_NAME = "INSTANCE_NAME";
    public static final String INSTANCE_DESCRIPTION = "INSTANCE_DESCRIPTION";

    // Hostgroup data
    public static final String HOSTGROUP_ID = "HOSTGROUP_ID";
    public static final String HOSTGROUP_OBJECT_ID = "HOSTGROUP_OBJECT_ID";
    public static final String HOSTGROUP_INSTANCE_ID = "HOSTGROUP_INSTANCE_ID";
    public static final String HOSTGROUP_NAME = "HOSTGROUP_NAME";
    public static final String HOSTGROUP_ALIAS = "HOSTGROUP_ALIAS";

    // Servicegroup data
    public static final String SERVICEGROUP_ID = "SERVICEGROUP_ID";
    public static final String SERVICEGROUP_OBJECT_ID = "SERVICEGROUP_OBJECT_ID";
    public static final String SERVICEGROUP_INSTANCE_ID = "SERVICEGROUP_INSTANCE_ID";
    public static final String SERVICEGROUP_NAME = "SERVICEGROUP_NAME";
    public static final String SERVICEGROUP_ALIAS = "SERVICEGROUP_ALIAS";

    // Contactgroup data
    public static final String CONTACTGROUP_ID = "CONTACTGROUP_ID";
    public static final String CONTACTGROUP_OBJECT_ID = "CONTACTGROUP_OBJECT_ID";
    public static final String CONTACTGROUP_INSTANCE_ID = "CONTACTGROUP_INSTANCE_ID";
    public static final String CONTACTGROUP_NAME = "CONTACTGROUP_NAME";
    public static final String CONTACTGROUP_ALIAS = "CONTACTGROUP_ALIAS";

    // Contact data
    public static final String CONTACT_NAME = "CONTACT_NAME";
    public static final String CONTACT_CUSTOMVARIABLE_NAME = "CONTACT_CUSTOMVARIABLE_NAME";
    public static final String CONTACT_CUSTOMVARIABLE_VALUE = "CONTACT_CUSTOMVARIABLE_VALUE";
    public static final String CONTACT_CONTACT_ID = "CONTACT_CONTACT_ID";
    public static final String CONTACT_INSTANCE_ID = "CONTACT_INSTANCE_ID";
    public static final String CONTACT_CONFIG_TYPE = "CONTACT_CONFIG_TYPE";
    public static final String CONTACT_CONTACT_OBJECT_ID = "CONTACT_CONTACT_OBJECT_ID";
    public static final String CONTACT_ALIAS = "CONTACT_ALIAS";
    public static final String CONTACT_EMAIL_ADDRESS = "CONTACT_EMAIL_ADDRESS";
    public static final String CONTACT_PAGER_ADDRESS = "CONTACT_PAGER_ADDRESS";
    public static final String CONTACT_HOST_TIMEPERIOD_OBJECT_ID = "CONTACT_HOST_TIMEPERIOD_OBJECT_ID";
    public static final String CONTACT_SERVICE_TIMEPERIOD_OBJECT_ID = "CONTACT_SERVICE_TIMEPERIOD_OBJECT_ID";
    public static final String CONTACT_HOST_NOTIFICATIONS_ENABLED = "CONTACT_HOST_NOTIFICATIONS_ENABLED";
    public static final String CONTACT_SERVICE_NOTIFICATIONS_ENABLED = "CONTACT_SERVICE_NOTIFICATIONS_ENABLED";
    public static final String CONTACT_CAN_SUBMIT_COMMANDS = "CONTACT_CAN_SUBMIT_COMMANDS";
    public static final String CONTACT_NOTIFY_SERVICE_RECOVERY = "CONTACT_NOTIFY_SERVICE_RECOVERY";
    public static final String CONTACT_NOTIFY_SERVICE_WARNING = "CONTACT_NOTIFY_SERVICE_WARNING";
    public static final String CONTACT_NOTIFY_SERVICE_UNKNOWN = "CONTACT_NOTIFY_SERVICE_UNKNOWN";
    public static final String CONTACT_NOTIFY_SERVICE_CRITICAL = "CONTACT_NOTIFY_SERVICE_CRITICAL";
    public static final String CONTACT_NOTIFY_SERVICE_FLAPPING = "CONTACT_NOTIFY_SERVICE_FLAPPING";
    public static final String CONTACT_NOTIFY_SERVICE_DOWNTIME = "CONTACT_NOTIFY_SERVICE_DOWNTIME";
    public static final String CONTACT_NOTIFY_HOST_RECOVERY = "CONTACT_NOTIFY_HOST_RECOVERY";
    public static final String CONTACT_NOTIFY_HOST_DOWN = "CONTACT_NOTIFY_HOST_DOWN";
    public static final String CONTACT_NOTIFY_HOST_UNREACHABLE = "CONTACT_NOTIFY_HOST_UNREACHABLE";
    public static final String CONTACT_NOTIFY_HOST_FLAPPING = "CONTACT_NOTIFY_HOST_FLAPPING";
    public static final String CONTACT_NOTIFY_HOST_DOWNTIME = "CONTACT_NOTIFY_HOST_DOWNTIME";

    // Timeperiod data
    public static final String TIMEPERIOD_ID = "TIMEPERIOD_ID";
    public static final String TIMEPERIOD_OBJECT_ID = "TIMEPERIOD_OBJECT_ID";
    public static final String TIMEPERIOD_INSTANCE_ID = "TIMEPERIOD_INSTANCE_ID";
    public static final String TIMEPERIOD_NAME = "TIMEPERIOD_NAME";
    public static final String TIMEPERIOD_ALIAS = "TIMEPERIOD_ALIAS";
    public static final String TIMEPERIOD_DAY = "TIMEPERIOD_DAY";
    public static final String TIMEPERIOD_STARTTIME = "TIMEPERIOD_STARTTIME";
    public static final String TIMEPERIOD_ENDTIME = "TIMEPERIOD_ENDTIME";

    // Customvariable data
    public static final String CUSTOMVARIABLE_ID = "CUSTOMVARIABLE_ID";
    public static final String CUSTOMVARIABLE_OBJECT_ID = "CUSTOMVARIABLE_OBJECT_ID";
    public static final String CUSTOMVARIABLE_INSTANCE_ID = "CUSTOMVARIABLE_INSTANCE_ID";
    public static final String CUSTOMVARIABLE_NAME = "CUSTOMVARIABLE_NAME";
    public static final String CUSTOMVARIABLE_VALUE = "CUSTOMVARIABLE_VALUE";
    public static final String CUSTOMVARIABLE_MODIFIED = "CUSTOMVARIABLE_MODIFIED";
    public static final String CUSTOMVARIABLE_UPDATETIME = "CUSTOMVARIABLE_UPDATETIME";

    // Host data
    public static final String HOST_ID = "HOST_ID";
    public static final String HOST_OBJECT_ID = "HOST_OBJECT_ID";
    public static final String HOST_INSTANCE_ID = "HOST_INSTANCE_ID";
    public static final String HOST_NAME = "HOST_NAME";
    public static final String HOST_ALIAS = "HOST_ALIAS";
    public static final String HOST_DISPLAY_NAME = "HOST_DISPLAY_NAME";
    public static final String HOST_ADDRESS = "HOST_ADDRESS";
    public static final String HOST_ADDRESS6 = "HOST_ADDRESS6";
    public static final String HOST_CONFIG_TYPE = "HOST_CONFIG_TYPE";
    public static final String HOST_FLAP_DETECTION_ENABLED = "HOST_FLAP_DETECTION_ENABLED";
    public static final String HOST_FRESHNESS_CHECKS_ENABLED = "HOST_FRESHNESS_CHECKS_ENABLED";
    public static final String HOST_FRESHNESS_THRESHOLD = "HOST_FRESHNESS_THRESHOLD";
    public static final String HOST_PASSIVE_CHECKS_ENABLED = "HOST_PASSIVE_CHECKS_ENABLED";
    public static final String HOST_EVENT_HANDLER_ENABLED = "HOST_EVENT_HANDLER_ENABLED";
    public static final String HOST_ACTIVE_CHECKS_ENABLED = "HOST_ACTIVE_CHECKS_ENABLED";
    public static final String HOST_RETAIN_STATUS_INFORMATION = "HOST_RETAIN_STATUS_INFORMATION";
    public static final String HOST_RETAIN_NONSTATUS_INFORMATION = "HOST_RETAIN_NONSTATUS_INFORMATION";
    public static final String HOST_NOTIFICATIONS_ENABLED = "HOST_NOTIFICATIONS_ENABLED";
    public static final String HOST_OBSESS_OVER_HOST = "HOST_OBSESS_OVER_HOST";
    public static final String HOST_FAILURE_PREDICTION_ENABLED = "HOST_FAILURE_PREDICTION_ENABLED";
    public static final String HOST_NOTES = "HOST_NOTES";
    public static final String HOST_NOTES_URL = "HOST_NOTES_URL";
    public static final String HOST_ACTION_URL = "HOST_ACTION_URL";
    public static final String HOST_ICON_IMAGE = "HOST_ICON_IMAGE";
    public static final String HOST_ICON_IMAGE_ALT = "HOST_ICON_IMAGE_ALT";
    public static final String HOST_IS_ACTIVE = "HOST_IS_ACTIVE";
    public static final String HOST_OUTPUT = "HOST_OUTPUT";
    public static final String HOST_LONG_OUTPUT = "HOST_LONG_OUTPUT";
    public static final String HOST_PERFDATA = "HOST_PERFDATA";
    public static final String HOST_CURRENT_STATE = "HOST_CURRENT_STATE";
    public static final String HOST_CURRENT_CHECK_ATTEMPT = "HOST_CURRENT_CHECK_ATTEMPT";
    public static final String HOST_MAX_CHECK_ATTEMPTS = "HOST_MAX_CHECK_ATTEMPTS";
    public static final String HOST_LAST_CHECK = "HOST_LAST_CHECK";
    public static final String HOST_LAST_STATE_CHANGE = "HOST_LAST_STATE_CHANGE";
    public static final String HOST_CHECK_TYPE = "HOST_CHECK_TYPE";
    public static final String HOST_LATENCY = "HOST_LATENCY";
    public static final String HOST_EXECUTION_TIME = "HOST_EXECUTION_TIME";
    public static final String HOST_NEXT_CHECK = "HOST_NEXT_CHECK";
    public static final String HOST_HAS_BEEN_CHECKED = "HOST_HAS_BEEN_CHECKED";
    public static final String HOST_LAST_HARD_STATE_CHANGE = "HOST_LAST_HARD_STATE_CHANGE";
    public static final String HOST_LAST_NOTIFICATION = "HOST_LAST_NOTIFICATION";
    public static final String HOST_PROCESS_PERFORMANCE_DATA = "HOST_PROCESS_PERFORMANCE_DATA";
    public static final String HOST_STATE_TYPE = "HOST_STATE_TYPE";
    public static final String HOST_IS_FLAPPING = "HOST_IS_FLAPPING";
    public static final String HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED = "HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED";
    public static final String HOST_SCHEDULED_DOWNTIME_DEPTH = "HOST_SCHEDULED_DOWNTIME_DEPTH";
    public static final String HOST_SHOULD_BE_SCHEDULED = "HOST_SHOULD_BE_SCHEDULED";
    public static final String HOST_STATUS_UPDATE_TIME = "HOST_STATUS_UPDATE_TIME";
    public static final String HOST_ALL = "HOST_ALL";
    public static final String HOST_STATUS_ALL = "HOST_STATUS_ALL";
    public static final String HOST_CHECK_SOURCE = "HOST_CHECK_SOURCE";
    public static final String HOST_STATE = "HOST_STATE";
    public static final String HOST_STATE_COUNT = "HOST_STATE_COUNT";
    public static final String HOST_OBJECT_COUNT = "HOST_OBJECT_COUNT";
    public static final String HOST_PARENT_OBJECT_ID = "HOST_PARENT_OBJECT_ID";
    public static final String HOST_PARENT_NAME = "HOST_PARENT_NAME";
    public static final String HOST_CHILD_OBJECT_ID = "HOST_CHILD_OBJECT_ID";
    public static final String HOST_CHILD_NAME = "HOST_CHILD_NAME";
    public static final String HOST_CUSTOMVARIABLE_NAME = "HOST_CUSTOMVARIABLE_NAME";
    public static final String HOST_CUSTOMVARIABLE_VALUE = "HOST_CUSTOMVARIABLE_VALUE";
    public static final String HOST_CURRENT_PROBLEM_STATE = "HOST_CURRENT_PROBLEM_STATE";
    public static final String HOST_IS_PENDING = "HOST_IS_PENDING";

    // Service data
    public static final String SERVICE_ID = "SERVICE_ID";
    public static final String SERVICE_INSTANCE_ID = "SERVICE_INSTANCE_ID";
    public static final String SERVICE_CONFIG_TYPE = "SERVICE_CONFIG_TYPE";
    public static final String SERVICE_IS_ACTIVE = "SERVICE_IS_ACTIVE";
    public static final String SERVICE_OBJECT_ID = "SERVICE_OBJECT_ID";
    public static final String SERVICE_NAME = "SERVICE_NAME";
    public static final String SERVICE_DISPLAY_NAME = "SERVICE_DISPLAY_NAME";
    public static final String SERVICE_NOTIFICATIONS_ENABLED = "SERVICE_NOTIFICATIONS_ENABLED";
    public static final String SERVICE_FLAP_DETECTION_ENABLED = "SERVICE_FLAP_DETECTION_ENABLED";
    public static final String SERVICE_PASSIVE_CHECKS_ENABLED = "SERVICE_PASSIVE_CHECKS_ENABLED";
    public static final String SERVICE_EVENT_HANDLER_ENABLED = "SERVICE_EVENT_HANDLER_ENABLED";
    public static final String SERVICE_ACTIVE_CHECKS_ENABLED = "SERVICE_ACTIVE_CHECKS_ENABLED";
    public static final String SERVICE_RETAIN_STATUS_INFORMATION = "SERVICE_RETAIN_STATUS_INFORMATION";
    public static final String SERVICE_RETAIN_NONSTATUS_INFORMATION = "SERVICE_RETAIN_NONSTATUS_INFORMATION";
    public static final String SERVICE_OBSESS_OVER_SERVICE = "SERVICE_OBSESS_OVER_SERVICE";
    public static final String SERVICE_FAILURE_PREDICTION_ENABLED = "SERVICE_FAILURE_PREDICTION_ENABLED";
    public static final String SERVICE_NOTES = "SERVICE_NOTES";
    public static final String SERVICE_NOTES_URL = "SERVICE_NOTES_URL";
    public static final String SERVICE_ACTION_URL = "SERVICE_ACTION_URL";
    public static final String SERVICE_ICON_IMAGE = "SERVICE_ICON_IMAGE";
    public static final String SERVICE_ICON_IMAGE_ALT = "SERVICE_ICON_IMAGE_ALT";
    public static final String SERVICE_OUTPUT = "SERVICE_OUTPUT";
    public static final String SERVICE_LONG_OUTPUT = "SERVICE_LONG_OUTPUT";
    public static final String SERVICE_PERFDATA = "SERVICE_PERFDATA";
    public static final String SERVICE_PROCESS_PERFORMANCE_DATA = "SERVICE_PROCESS_PERFORMANCE_DATA";
    public static final String SERVICE_CURRENT_STATE = "SERVICE_CURRENT_STATE";
    public static final String SERVICE_CURRENT_CHECK_ATTEMPT = "SERVICE_CURRENT_CHECK_ATTEMPT";
    public static final String SERVICE_MAX_CHECK_ATTEMPTS = "SERVICE_MAX_CHECK_ATTEMPTS";
    public static final String SERVICE_LAST_CHECK = "SERVICE_LAST_CHECK";
    public static final String SERVICE_LAST_STATE_CHANGE = "SERVICE_LAST_STATE_CHANGE";
    public static final String SERVICE_CHECK_TYPE = "SERVICE_CHECK_TYPE";
    public static final String SERVICE_LATENCY = "SERVICE_LATENCY";
    public static final String SERVICE_EXECUTION_TIME = "SERVICE_EXECUTION_TIME";
    public static final String SERVICE_NEXT_CHECK = "SERVICE_NEXT_CHECK";
    public static final String SERVICE_HAS_BEEN_CHECKED = "SERVICE_HAS_BEEN_CHECKED";
    public static final String SERVICE_LAST_HARD_STATE = "SERVICE_LAST_HARD_STATE";
    public static final String SERVICE_LAST_HARD_STATE_CHANGE = "SERVICE_LAST_HARD_STATE_CHANGE";
    public static final String SERVICE_LAST_NOTIFICATION = "SERVICE_LAST_NOTIFICATION";
    public static final String SERVICE_STATE_TYPE = "SERVICE_STATE_TYPE";
    public static final String SERVICE_IS_FLAPPING = "SERVICE_IS_FLAPPING";
    public static final String SERVICE_PROBLEM_HAS_BEEN_ACKNOWLEDGED = "SERVICE_PROBLEM_HAS_BEEN_ACKNOWLEDGED";
    public static final String SERVICE_SCHEDULED_DOWNTIME_DEPTH = "SERVICE_SCHEDULED_DOWNTIME_DEPTH";
    public static final String SERVICE_SHOULD_BE_SCHEDULED = "SERVICE_SHOULD_BE_SCHEDULED";
    public static final String SERVICE_STATUS_UPDATE_TIME = "SERVICE_STATUS_UPDATE_TIME";
    public static final String SERVICE_ALL = "SERVICE_ALL";
    public static final String SERVICE_STATUS_ALL = "SERVICE_STATUS_ALL";
    public static final String SERVICE_CUSTOMVARIABLE_NAME = "SERVICE_CUSTOMVARIABLE_NAME";
    public static final String SERVICE_CUSTOMVARIABLE_VALUE = "SERVICE_CUSTOMVARIABLE_VALUE";
    public static final String SERVICE_STATE_COUNT = "SERVICE_STATE_COUNT";
    public static final String SERVICE_OBJECT_COUNT = "SERVICE_OBJECT_COUNT";
    public static final String SERVICE_CURRENT_PROBLEM_STATE = "SERVICE_CURRENT_PROBLEM_STATE";
    public static final String SERVICE_IS_PENDING = "SERVICE_IS_PENDING";
    public static final String SERVICE_CHECK_SOURCE = "SERVICE_CHECK_SOURCE";

    // Config vars
    public static final String CONFIG_VAR_ID = "CONFIG_VAR_ID";
    public static final String CONFIG_VAR_INSTANCE_ID = "CONFIG_VAR_INSTANCE_ID";
    public static final String CONFIG_VAR_NAME = "CONFIG_VAR_NAME";
    public static final String CONFIG_VAR_VALUE = "CONFIG_VAR_VALUE";

    // Logentries
    public static final String LOG_ID = "LOG_ID";
    public static final String LOG_INSTANCE_ID = "LOG_INSTANCE_ID";
    public static final String LOG_TIME = "LOG_TIME";
    public static final String LOG_ENTRY_TIME = "LOG_ENTRY_TIME";
    public static final String LOG_ENTRY_TIME_USEC = "LOG_ENTRY_TIME_USEC";
    public static final String LOG_TYPE = "LOG_TYPE";
    public static final String LOG_DATA = "LOG_DATA";
    public static final String LOG_REALTIME_DATA = "LOG_REALTIME_DATA";
    public static final String LOG_INFERRED_DATA = "LOG_INFERRED_DATA";

    // Commands
    public static final String COMMAND_NAME = "COMMAND_NAME";
    public static final String COMMAND_ID = "COMMAND_ID";
    public static final String COMMAND_INSTANCE_ID = "COMMAND_INSTANCE_ID";
    public static final String COMMAND_CONFIG_TYPE = "COMMAND_CONFIG_TYPE";
    public static final String COMMAND_OBJECT_ID = "COMMAND_OBJECT_ID";
    public static final String COMMAND_COMMAND_LINE = "COMMAND_COMMAND_LINE";

    // Statehistory
    public static final String STATEHISTORY_ID = "STATEHISTORY_ID";
    public static final String STATEHISTORY_INSTANCE_ID = "STATEHISTORY_INSTANCE_ID";
    public static final String STATEHISTORY_STATE_TIME = "STATEHISTORY_STATE_TIME";
    public static final String STATEHISTORY_STATE_TIME_USEC = "STATEHISTORY_STATE_TIME_USEC";
    public static final String STATEHISTORY_OBJECT_ID = "STATEHISTORY_OBJECT_ID";
    public static final String STATEHISTORY_STATE_CHANGE = "STATEHISTORY_STATE_CHANGE";
    public static final String STATEHISTORY_STATE = "STATEHISTORY_STATE";
    public static final String STATEHISTORY_STATE_TYPE = "STATEHISTORY_STATE_TYPE";
    public static final String STATEHISTORY_CURRENT_CHECK_ATTEMPT = "STATEHISTORY_CURRENT_CHECK_ATTEMPT";
    public static final String STATEHISTORY_MAX_CHECK_ATTEMPTS = "STATEHISTORY_MAX_CHECK_ATTEMPTS";
    public static final String STATEHISTORY_LAST_STATE = "STATEHISTORY_LAST_STATE";
    public static final String STATEHISTORY_LAST_HARD_STATE = "STATEHISTORY_LAST_HARD_STATE";
    public static final String STATEHISTORY_OUTPUT = "STATEHISTORY_OUTPUT";
    public static final String STATEHISTORY_LONG_OUTPUT = "STATEHISTORY_LONG_OUTPUT";

    // Notifications
    public static final String NOTIFICATION_ID = "NOTIFICATION_ID";
    public static final String NOTIFICATION_INSTANCE_ID = "NOTIFICATION_INSTANCE_ID";
    public static final String NOTIFICATION_TYPE = "NOTIFICATION_TYPE";
    public static final String NOTIFICATION_CONTACT = "NOTIFICATION_CONTACT";
    public static final String NOTIFICATION_REASON = "NOTIFICATION_REASON";
    public static final String NOTIFICATION_STARTTIME = "NOTIFICATION_STARTTIME";
    public static final String NOTIFICATION_STARTTIME_USEC = "NOTIFICATION_STARTTIME_USEC";
    public static final String NOTIFICATION_ENDTIME = "NOTIFICATION_ENDTIME";
    public static final String NOTIFICATION_ENDTIME_USEC = "NOTIFICATION_ENDTIME_USEC";
    public static final String NOTIFICATION_STATE = "NOTIFICATION_STATE";
    public static final String NOTIFICATION_OUTPUT = "NOTIFICATION_OUTPUT";
    public static final String NOTIFICATION_LONG_OUTPUT = "NOTIFICATION_LONG_OUTPUT";
    public static final String NOTIFICATION_ESCALATED = "NOTIFICATION_ESCALATED";
    public static final String NOTIFICATION_NOTIFIED = "NOTIFICATION_NOTIFIED";
    public static final String NOTIFICATION_OBJECT_ID = "NOTIFICATION_OBJECT_ID";
    public static final String NOTIFICATION_OBJECTTYPE_ID = "NOTIFICATION_OBJECTTYPE_ID";

    // Summary queries
    public static final String HOSTGROUP_SUMMARY_COUNT = "HOSTGROUP_SUMMARY_COUNT";
    public static final String SERVICEGROUP_SUMMARY_COUNT = "SERVICEGROUP_SUMMARY_COUNT";

    // Comments
    public static final String COMMENT_ID = "COMMENT_ID";
    public static final String COMMENT_INSTANCE_ID = "COMMENT_INSTANCE_ID";
    public static final String COMMENT_ENTRY_TIME = "COMMENT_ENTRY_TIME";
    public static final String COMMENT_ENTRY_TIME_USEC = "COMMENT_ENTRY_TIME_USEC";
    public static final String COMMENT_TYPE = "COMMENT_TYPE";
    public static final String COMMENT_ENTRY_TYPE = "COMMENT_ENTRY_TYPE";
    public static final String COMMENT_OBJECT_ID = "COMMENT_OBJECT_ID";
    public static final String COMMENT_TIME = "COMMENT_TIME";
    public static final String COMMENT_INTERNAL_ID = "COMMENT_INTERNAL_ID";
    public static final String COMMENT_AUTHOR_NAME = "COMMENT_AUTHOR_NAME";
    public static final String COMMENT_DATA = "COMMENT_DATA";
    public static final String COMMENT_IS_PERSISTENT = "COMMENT_IS_PERSISTENT";
    public static final String COMMENT_SOURCE = "COMMENT_SOURCE";
    public static final String COMMENT_EXPIRES = "COMMENT_EXPIRES";
    public static final String COMMENT_EXPIRATION_TIME = "COMMENT_EXPIRATION_TIME";

    // Downtimehistory
    public static final String DOWNTIMEHISTORY_ID = "DOWNTIMEHISTORY_ID";
    public static final String DOWNTIMEHISTORY_INSTANCE_ID = "DOWNTIMEHISTORY_INSTANCE_ID";
    public static final String DOWNTIMEHISTORY_DOWNTIME_TYPE = "DOWNTIMEHISTORY_DOWNTIME_TYPE";
    public static final String DOWNTIMEHISTORY_OBJECT_ID = "DOWNTIMEHISTORY_OBJECT_ID";
    public static final String DOWNTIMEHISTORY_ENTRY_TIME = "DOWNTIMEHISTORY_ENTRY_TIME";
    public static final String DOWNTIMEHISTORY_AUTHOR_NAME = "DOWNTIMEHISTORY_AUTHOR_NAME";
    public static final String DOWNTIMEHISTORY_COMMENT_DATA = "DOWNTIMEHISTORY_COMMENT_DATA";
    public static final String DOWNTIMEHISTORY_INTERNAL_DOWNTIME_ID = "DOWNTIMEHISTORY_INTERNAL_DOWNTIME_ID";
    public static final String DOWNTIMEHISTORY_TRIGGERED_BY_ID = "DOWNTIMEHISTORY_TRIGGERED_BY_ID";
    public static final String DOWNTIMEHISTORY_IS_FIXED = "DOWNTIMEHISTORY_IS_FIXED";
    public static final String DOWNTIMEHISTORY_DURATION = "DOWNTIMEHISTORY_DURATION";
    public static final String DOWNTIMEHISTORY_SCHEDULED_START_TIME = "DOWNTIMEHISTORY_SCHEDULED_START_TIME";
    public static final String DOWNTIMEHISTORY_SCHEDULED_END_TIME = "DOWNTIMEHISTORY_SCHEDULED_END_TIME";
    public static final String DOWNTIMEHISTORY_WAS_STARTED = "DOWNTIMEHISTORY_WAS_STARTED";
    public static final String DOWNTIMEHISTORY_ACTUAL_START_TIME = "DOWNTIMEHISTORY_ACTUAL_START_TIME";
    public static final String DOWNTIMEHISTORY_ACTUAL_START_TIME_USEC = "DOWNTIMEHISTORY_ACTUAL_START_TIME_USEC";
    public static final String DOWNTIMEHISTORY_ACTUAL_END_TIME = "DOWNTIMEHISTORY_ACTUAL_END_TIME";
    public static final String DOWNTIMEHISTORY_ACTUAL_END_TIME_USEC = "DOWNTIMEHISTORY_ACTUAL_END_TIME_USEC";
    public static final String DOWNTIMEHISTORY_WAS_CANCELLED = "DOWNTIMEHISTORY_WAS_CANCELLED";

    // Downtime
    public static final String DOWNTIME_ID = "DOWNTIME_ID";
    public static final String DOWNTIME_INSTANCE_ID = "DOWNTIME_INSTANCE_ID";
    public static final String DOWNTIME_DOWNTIME_TYPE = "DOWNTIME_DOWNTIME_TYPE";
    public static final String DOWNTIME_OBJECT_ID = "DOWNTIME_OBJECT_ID";
    public static final String DOWNTIME_ENTRY_TIME = "DOWNTIME_ENTRY_TIME";
    public static final String DOWNTIME_AUTHOR_NAME = "DOWNTIME_AUTHOR_NAME";
    public static final String DOWNTIME_COMMENT_DATA = "DOWNTIME_COMMENT_DATA";
    public static final String DOWNTIME_INTERNAL_DOWNTIME_ID = "DOWNTIME_INTERNAL_DOWNTIME_ID";
    public static final String DOWNTIME_TRIGGERED_BY_ID = "DOWNTIME_TRIGGERED_BY_ID";
    public static final String DOWNTIME_IS_FIXED = "DOWNTIME_IS_FIXED";
    public static final String DOWNTIME_DURATION = "DOWNTIME_DURATION";
    public static final String DOWNTIME_SCHEDULED_START_TIME = "DOWNTIME_SCHEDULED_START_TIME";
    public static final String DOWNTIME_SCHEDULED_END_TIME = "DOWNTIME_SCHEDULED_END_TIME";
    public static final String DOWNTIME_WAS_STARTED = "DOWNTIME_WAS_STARTED";
    public static final String DOWNTIME_ACTUAL_START_TIME = "DOWNTIME_ACTUAL_START_TIME";
    public static final String DOWNTIME_ACTUAL_START_TIME_USEC = "DOWNTIME_ACTUAL_START_TIME_USEC";

}
