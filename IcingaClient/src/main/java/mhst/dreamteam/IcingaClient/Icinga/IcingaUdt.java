package mhst.dreamteam.IcingaClient.Icinga;

/**
 * Contains Icinga user-define template. IcingaUdt stands for 'Icinga User-Define Template'.<br />
 * First, declare a constant identify the template<br />
 * Then, implement the template in method getTemplate() by using IcingaParam class or directly String variable
 *
 * @author MinhNN
 * @see mhst.dreamteam.IcingaClient.Icinga.IcingaParam
 * @see mhst.dreamteam.IcingaClient.Icinga.IcingaConst
 */
public class IcingaUdt {
    // Declare template identify constant here
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_HOST = 1; // Template to use in main activity to get list host
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_OKHOST = 2; // Template to use in main activity to get list ok host
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_DOWNHOST = 3;// Template to use in main activity to get list down host
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_UNREACHABLEHOST = 4; // Template to use in main activity to get list unreachable host
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_PENDINGHOST = 5; //Template to use in main activity to get list host which is pending
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_SERVICE = 6; // Template to use in main activity to get list service
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_WARNINGSERVICE = 7; // Template to use in main activity to get list service  which is warning
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_CRITICALSERVICE = 8; // Template to use in main activity to get list critical service
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_OKSERVICE = 9; // Template to use in main activity to get list ok service
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_UNKNOWSERVICE = 10; // Template to use in main activity to get list unknow service

    /**
     * Returns Icinga parameter String via template defined.
     *
     * @param nTemplate an integer that define the template
     * @return a icinga parameter string
     */
    public static String getTemplate(int nTemplate, int start, int end, String hostObjectId) {
        /**
         * By using this method, you need to declare a constant above, then add a 'case' condition below
         * and change the value of the variable named 'result' in switch-case block.
         */

        // This is the variable mentioned above. The method will return the value of this variable.
        String result = "";
        IcingaParam param;
        // This is where we process the result. Change the value of result here.
        switch (nTemplate) {
            // First approach, using IcingaParam
            case ICINGA_TEMPLATE_MAINACTIVITY_HOST:
                param = new IcingaParam(); // create icinga parameter

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId + ")]");
                }

                param.setTarget(IcingaConst.TARGET_HOST) // set target
                    .setCountField(IcingaConst.HOST_OBJECT_ID)
                    .setOrder(IcingaConst.HOST_OBJECT_ID, "ASC")
                    .setColumns(IcingaConst.HOST_OBJECT_ID, IcingaConst.HOST_NAME,
                            IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.HOST_ADDRESS, IcingaConst.HOST_ADDRESS6,
                            IcingaConst.HOST_PERFDATA, IcingaConst.HOST_CURRENT_STATE,
                            IcingaConst.HOST_LATENCY, IcingaConst.HOST_LAST_CHECK,
                            IcingaConst.HOST_NEXT_CHECK, IcingaConst.HOST_CURRENT_CHECK_ATTEMPT,
                            IcingaConst.HOST_MAX_CHECK_ATTEMPTS, IcingaConst.HOST_CHECK_TYPE,
                            IcingaConst.HOST_LAST_STATE_CHANGE, IcingaConst.HOST_ACTION_URL,
                            IcingaConst.HOST_NOTES, IcingaConst.HOST_IS_PENDING,
                            IcingaConst.HOST_NOTIFICATIONS_ENABLED, IcingaConst.HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED,
                            IcingaConst.HOST_HAS_BEEN_CHECKED) // set the columns to show
                    .setOutput("json"); // set type of data response

                // Attention! Every case condition must assign value to result like this!
                result = param.toString(); // convert parameter to string
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_DOWNHOST:
                param = new IcingaParam(); // create icinga parameter

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId + ";"
                            + IcingaConst.HOST_CURRENT_STATE + "|=|" + IcingaApiConst.HOST_STATE_DOWN + ")]");// if filter not null
                } else {
                    param.setFilters("[AND(" + IcingaConst.HOST_CURRENT_STATE + "|=|" + IcingaApiConst.HOST_STATE_DOWN + ")]");
                }

                param.setTarget(IcingaConst.TARGET_HOST) // set target
                    .setCountField(IcingaConst.HOST_OBJECT_ID)
                    .setColumns(IcingaConst.HOST_OBJECT_ID, IcingaConst.HOST_NAME,
                            IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.HOST_ADDRESS, IcingaConst.HOST_ADDRESS6,
                            IcingaConst.HOST_PERFDATA, IcingaConst.HOST_CURRENT_STATE,
                            IcingaConst.HOST_LATENCY, IcingaConst.HOST_LAST_CHECK,
                            IcingaConst.HOST_NEXT_CHECK, IcingaConst.HOST_CURRENT_CHECK_ATTEMPT,
                            IcingaConst.HOST_MAX_CHECK_ATTEMPTS, IcingaConst.HOST_CHECK_TYPE,
                            IcingaConst.HOST_LAST_STATE_CHANGE, IcingaConst.HOST_ACTION_URL,
                            IcingaConst.HOST_NOTES, IcingaConst.HOST_IS_PENDING,
                            IcingaConst.HOST_NOTIFICATIONS_ENABLED, IcingaConst.HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED,
                            IcingaConst.HOST_HAS_BEEN_CHECKED) // set the columns to show
                    .setOutput("json"); // set type of data response

                // Attention! Every case condition must assign value to result like this!
                result = param.toString(); // convert parameter to string
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_UNREACHABLEHOST:
                param = new IcingaParam(); // create icinga parameter

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId + ";"
                            + IcingaConst.HOST_CURRENT_STATE + "|=|" + IcingaApiConst.HOST_STATE_UNREACHABLE + ")]");// if filter not null
                } else {
                    param.setFilters("[AND(" + IcingaConst.HOST_CURRENT_STATE + "|=|" + IcingaApiConst.HOST_STATE_UNREACHABLE + ")]");
                }

                param.setTarget(IcingaConst.TARGET_HOST) // set target
                    .setCountField(IcingaConst.HOST_OBJECT_ID)
                    .setColumns(IcingaConst.HOST_OBJECT_ID, IcingaConst.HOST_NAME,
                            IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.HOST_ADDRESS, IcingaConst.HOST_ADDRESS6,
                            IcingaConst.HOST_PERFDATA, IcingaConst.HOST_CURRENT_STATE,
                            IcingaConst.HOST_LATENCY, IcingaConst.HOST_LAST_CHECK,
                            IcingaConst.HOST_NEXT_CHECK, IcingaConst.HOST_CURRENT_CHECK_ATTEMPT,
                            IcingaConst.HOST_MAX_CHECK_ATTEMPTS, IcingaConst.HOST_CHECK_TYPE,
                            IcingaConst.HOST_LAST_STATE_CHANGE, IcingaConst.HOST_ACTION_URL,
                            IcingaConst.HOST_NOTES, IcingaConst.HOST_IS_PENDING,
                            IcingaConst.HOST_NOTIFICATIONS_ENABLED, IcingaConst.HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED,
                            IcingaConst.HOST_HAS_BEEN_CHECKED) // set the columns to show
                    .setOutput("json"); // set type of data response

                // Attention! Every case condition must assign value to result like this!
                result = param.toString(); // convert parameter to string
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_PENDINGHOST:
                param = new IcingaParam(); // create icinga parameter

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId + ";"
                            + IcingaConst.HOST_IS_PENDING + "|=|" + 1 + ")]");// if filter not null
                } else {
                    param.setFilters("[AND(" + IcingaConst.HOST_IS_PENDING + "|=|" + 1 + ")]");
                }

                param.setTarget(IcingaConst.TARGET_HOST) // set target
                    .setCountField(IcingaConst.HOST_OBJECT_ID)
                    .setColumns(IcingaConst.HOST_OBJECT_ID, IcingaConst.HOST_NAME,
                            IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.HOST_ADDRESS, IcingaConst.HOST_ADDRESS6,
                            IcingaConst.HOST_PERFDATA, IcingaConst.HOST_CURRENT_STATE,
                            IcingaConst.HOST_LATENCY, IcingaConst.HOST_LAST_CHECK,
                            IcingaConst.HOST_NEXT_CHECK, IcingaConst.HOST_CURRENT_CHECK_ATTEMPT,
                            IcingaConst.HOST_MAX_CHECK_ATTEMPTS, IcingaConst.HOST_CHECK_TYPE,
                            IcingaConst.HOST_LAST_STATE_CHANGE, IcingaConst.HOST_ACTION_URL,
                            IcingaConst.HOST_NOTES, IcingaConst.HOST_IS_PENDING,
                            IcingaConst.HOST_NOTIFICATIONS_ENABLED, IcingaConst.HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED,
                            IcingaConst.HOST_HAS_BEEN_CHECKED) // set the columns to show
                    .setOutput("json"); // set type of data response

                // Attention! Every case condition must assign value to result like this!
                result = param.toString(); // convert parameter to string
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_OKHOST:
                param = new IcingaParam(); // create icinga parameter

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId + ";"
                            + IcingaConst.HOST_CURRENT_STATE + "|=|" + IcingaApiConst.HOST_STATE_OK + ")]");// if filter not null
                } else {
                    param.setFilters("[AND(" + IcingaConst.HOST_CURRENT_STATE + "|=|" + IcingaApiConst.HOST_STATE_OK + ")]");
                }

                param.setTarget(IcingaConst.TARGET_HOST) // set target
                    .setCountField(IcingaConst.HOST_OBJECT_ID)
                    .setColumns(IcingaConst.HOST_OBJECT_ID, IcingaConst.HOST_NAME,
                            IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.HOST_ADDRESS, IcingaConst.HOST_ADDRESS6,
                            IcingaConst.HOST_PERFDATA, IcingaConst.HOST_CURRENT_STATE,
                            IcingaConst.HOST_LATENCY, IcingaConst.HOST_LAST_CHECK,
                            IcingaConst.HOST_NEXT_CHECK, IcingaConst.HOST_CURRENT_CHECK_ATTEMPT,
                            IcingaConst.HOST_MAX_CHECK_ATTEMPTS, IcingaConst.HOST_CHECK_TYPE,
                            IcingaConst.HOST_LAST_STATE_CHANGE, IcingaConst.HOST_ACTION_URL,
                            IcingaConst.HOST_NOTES, IcingaConst.HOST_IS_PENDING,
                            IcingaConst.HOST_NOTIFICATIONS_ENABLED, IcingaConst.HOST_PROBLEM_HAS_BEEN_ACKNOWLEDGED,
                            IcingaConst.HOST_HAS_BEEN_CHECKED) // set the columns to show
                    .setOutput("json"); // set type of data response

                // Attention! Every case condition must assign value to result like this!
                result = param.toString(); // convert parameter to string
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_SERVICE:
                param = new IcingaParam();

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId + ")]");
                }

                param.setTarget(IcingaConst.TARGET_SERVICE)
                    .setCountField(IcingaConst.SERVICE_OBJECT_ID)
                    .setOrder(IcingaConst.SERVICE_OBJECT_ID, "ASC")
                    .setColumns(IcingaConst.SERVICE_OBJECT_ID, IcingaConst.SERVICE_OUTPUT,
                            IcingaConst.SERVICE_PERFDATA, IcingaConst.HOST_OBJECT_ID,
                            IcingaConst.SERVICE_NAME, IcingaConst.SERVICE_DISPLAY_NAME,
                            IcingaConst.SERVICE_PROCESS_PERFORMANCE_DATA, IcingaConst.SERVICE_CURRENT_STATE,
                            IcingaConst.SERVICE_LAST_STATE_CHANGE,
                            IcingaConst.SERVICE_LAST_CHECK, IcingaConst.SERVICE_NEXT_CHECK,
                            IcingaConst.SERVICE_ACTION_URL, IcingaConst.SERVICE_NOTES,
                            IcingaConst.SERVICE_CURRENT_CHECK_ATTEMPT, IcingaConst.SERVICE_MAX_CHECK_ATTEMPTS)
                    .setOutput("json");

                // Attention! Every case condition must assign value to result like this!
                result = param.toString();
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_WARNINGSERVICE:
                param = new IcingaParam();

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId
                            + IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_WARNING + ")]");
                } else {
                    param.setFilters("[AND(" + IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_WARNING + ")]");
                }

                param.setTarget(IcingaConst.TARGET_SERVICE)
                    .setCountField(IcingaConst.SERVICE_OBJECT_ID)
                    .setColumns(IcingaConst.SERVICE_OBJECT_ID, IcingaConst.SERVICE_OUTPUT,
                            IcingaConst.SERVICE_PERFDATA, IcingaConst.HOST_OBJECT_ID,
                            IcingaConst.HOST_NAME, IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.SERVICE_NAME, IcingaConst.SERVICE_DISPLAY_NAME,
                            IcingaConst.SERVICE_PROCESS_PERFORMANCE_DATA, IcingaConst.SERVICE_CURRENT_STATE,
                            IcingaConst.HOST_CURRENT_STATE, IcingaConst.SERVICE_LAST_STATE_CHANGE,
                            IcingaConst.SERVICE_LAST_CHECK, IcingaConst.SERVICE_NEXT_CHECK,
                            IcingaConst.SERVICE_ACTION_URL, IcingaConst.SERVICE_NOTES,
                            IcingaConst.SERVICE_CURRENT_CHECK_ATTEMPT, IcingaConst.SERVICE_MAX_CHECK_ATTEMPTS)
                    .setOutput("json");

                // Attention! Every case condition must assign value to result like this!
                result = param.toString();
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_CRITICALSERVICE:
                param = new IcingaParam();

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId +
                            IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_CRITICAL + ")]");
                } else {
                    param.setFilters("[AND(" + IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_CRITICAL + ")]");
                }

                param.setTarget(IcingaConst.TARGET_SERVICE)
                    .setCountField(IcingaConst.SERVICE_OBJECT_ID)
                    .setColumns(IcingaConst.SERVICE_OBJECT_ID, IcingaConst.SERVICE_OUTPUT,
                            IcingaConst.SERVICE_PERFDATA, IcingaConst.HOST_OBJECT_ID,
                            IcingaConst.HOST_NAME, IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.SERVICE_NAME, IcingaConst.SERVICE_DISPLAY_NAME,
                            IcingaConst.SERVICE_PROCESS_PERFORMANCE_DATA, IcingaConst.SERVICE_CURRENT_STATE,
                            IcingaConst.HOST_CURRENT_STATE, IcingaConst.SERVICE_LAST_STATE_CHANGE,
                            IcingaConst.SERVICE_LAST_CHECK, IcingaConst.SERVICE_NEXT_CHECK,
                            IcingaConst.SERVICE_ACTION_URL, IcingaConst.SERVICE_NOTES,
                            IcingaConst.SERVICE_CURRENT_CHECK_ATTEMPT, IcingaConst.SERVICE_MAX_CHECK_ATTEMPTS)
                    .setOutput("json");

                // Attention! Every case condition must assign value to result like this!
                result = param.toString();
                break;
            case ICINGA_TEMPLATE_MAINACTIVITY_OKSERVICE:
                param = new IcingaParam();

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId +
                            IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_OK + ")]");
                } else {
                    param.setFilters("[AND(" + IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_OK + ")]");
                }

                param.setTarget(IcingaConst.TARGET_SERVICE)
                    .setCountField(IcingaConst.SERVICE_OBJECT_ID)
                    .setColumns(IcingaConst.SERVICE_OBJECT_ID, IcingaConst.SERVICE_OUTPUT,
                            IcingaConst.SERVICE_PERFDATA, IcingaConst.HOST_OBJECT_ID,
                            IcingaConst.HOST_NAME, IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.SERVICE_NAME, IcingaConst.SERVICE_DISPLAY_NAME,
                            IcingaConst.SERVICE_PROCESS_PERFORMANCE_DATA, IcingaConst.SERVICE_CURRENT_STATE,
                            IcingaConst.HOST_CURRENT_STATE, IcingaConst.SERVICE_LAST_STATE_CHANGE,
                            IcingaConst.SERVICE_LAST_CHECK, IcingaConst.SERVICE_NEXT_CHECK,
                            IcingaConst.SERVICE_ACTION_URL, IcingaConst.SERVICE_NOTES,
                            IcingaConst.SERVICE_CURRENT_CHECK_ATTEMPT, IcingaConst.SERVICE_MAX_CHECK_ATTEMPTS)
                    .setOutput("json");

                // Attention! Every case condition must assign value to result like this!
                result = param.toString();
                break;

            case ICINGA_TEMPLATE_MAINACTIVITY_UNKNOWSERVICE:
                param = new IcingaParam();

                if (start >= 0) {
                    if (end == -1) {
                        param.setLimit(start);
                    } else if (end >= start) {
                        param.setLimit(start, end);
                    }
                }

                if (!isNullOrEmpty(hostObjectId)) {
                    param.setFilters("[AND(" + IcingaConst.HOST_OBJECT_ID + "|=|" + hostObjectId +
                            IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_UNKNOWN + ")]");
                } else {
                    param.setFilters("[AND(" + IcingaConst.SERVICE_CURRENT_STATE + "|=|"
                            + IcingaApiConst.SERVICE_STATE_UNKNOWN + ")]");
                }

                param.setTarget(IcingaConst.TARGET_SERVICE)
                    .setCountField(IcingaConst.SERVICE_OBJECT_ID)
                    .setColumns(IcingaConst.SERVICE_OBJECT_ID, IcingaConst.SERVICE_OUTPUT,
                            IcingaConst.SERVICE_PERFDATA, IcingaConst.HOST_OBJECT_ID,
                            IcingaConst.HOST_NAME, IcingaConst.HOST_ALIAS, IcingaConst.HOST_DISPLAY_NAME,
                            IcingaConst.SERVICE_NAME, IcingaConst.SERVICE_DISPLAY_NAME,
                            IcingaConst.SERVICE_PROCESS_PERFORMANCE_DATA, IcingaConst.SERVICE_CURRENT_STATE,
                            IcingaConst.HOST_CURRENT_STATE, IcingaConst.SERVICE_LAST_STATE_CHANGE,
                            IcingaConst.SERVICE_LAST_CHECK, IcingaConst.SERVICE_NEXT_CHECK,
                            IcingaConst.SERVICE_ACTION_URL, IcingaConst.SERVICE_NOTES,
                            IcingaConst.SERVICE_CURRENT_CHECK_ATTEMPT, IcingaConst.SERVICE_MAX_CHECK_ATTEMPTS)
                    .setOutput("json");

                // Attention! Every case condition must assign value to result like this!
                result = param.toString();
                break;

            // Second approach, using directly string, not recommended
            // case ICINGA_TEMPLATE_MAINACTIVITY_HOST:
            //    result = "/host/columns[...list of column...]/xml";
        }

        return result;
    }

    private static boolean isNullOrEmpty(String s) {
        return (s == null || s.isEmpty());
    }
}
