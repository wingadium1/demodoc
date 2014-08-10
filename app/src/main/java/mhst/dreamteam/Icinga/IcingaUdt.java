package mhst.dreamteam.Icinga;

/**
 * Contains Icinga user-define template. IcingaUdt stands for 'Icinga User-Define Template'.<br />
 * First, declare a constant identify the template<br />
 * Then, implement the template in method getTemplate() by using IcingaParam class or directly String variable
 * @author MinhNN
 * @see mhst.dreamteam.Icinga.IcingaParam
 * @see mhst.dreamteam.Icinga.IcingaConst
 */
public class IcingaUdt {
    // Declare template identify constant here
    public static final int ICINGA_TEMPLATE_MAINACTIVITY_HOST = 1; // Template to use in main activity to get list host

    /**
     * Returns Icinga parameter String via template defined.
     * @param nTemplate an integer that define the template
     * @return a icinga parameter string
     */
    public static String getTemplate(int nTemplate) {
        /**
         * By using this method, you need to declare a constant above, then add a 'case' condition below
         * and change the value of the variable named 'result' in switch-case block.
         */

        // This is the variable mentioned above. The method will return the value of this variable.
        String result = "";

        // This is where we process the result. Change the value of result here.
        switch (nTemplate) {
            // First approach, using IcingaParam
            case ICINGA_TEMPLATE_MAINACTIVITY_HOST:
                IcingaParam param = new IcingaParam(); // create icinga parameter

                param.setTarget(IcingaConst.TARGET_HOST) // set target
                        .setColumns(IcingaConst.HOST_STATE, IcingaConst.HOST_NAME,
                                IcingaConst.HOST_LATENCY, IcingaConst.HOST_LAST_CHECK) // set the columns to show
                        .setOutput("xml"); // set type of data response

                // Attention! Every case condition must assign value to result like this!
                result = param.toString(); // convert parameter to string
                break;
            // Second approach, using directly string, not recommended
            // case ICINGA_TEMPLATE_MAINACTIVITY_HOST:
            //    result = "/host/columns[...list of column...]/xml";
        }

        return result;
    }
}
