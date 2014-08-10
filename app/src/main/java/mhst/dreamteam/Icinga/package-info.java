/**
 * This package contains everything about communicating with icinga rest api.<br />
 * Before you do anything, please read this carefully.<br />
 * <h1>How to send a request to server and get response?</h1>
 * Everything you only need to do is to create the parameter string and pass to IcingaApi and get the return data.<br /><br />
 * +Create a parameter string by using {@code IcingaParam} or {@code IcingaUdt}:<br />
 * <div style="border: #606060 solid 1px; margin: 10px 10px 10px 10px; padding: 4px 4px 4px 4px; font-size: 4px;">
 *     <pre>{@code
 *     // Creat an instance
 *     IcingaParam params = new IcingaParam();
 *     // Set parameters
 *     params.setTarget(IcingaConst.TARGET_HOST);
 *     params.setColumns(IcingaConst.HOST_NAME);
 *     params.setOutput("json");
 *     // Get the parameter string
 *     String params_string = params.toString();}</pre>
 * </div>
 *
 * <div style="border: #606060 solid 1px; margin: 10px 10px 10px 10px; padding: 4px 4px 4px 4px; font-size: 4px;">
 *     <pre>{@code
 *     // Using template
 *     String params_string = IcingaUdt.getTemplate(IcingaUdt.ICINGA_TEMPLATE_MAINACTIVITY_HOST);}</pre>
 * </div>
 *
 * <i>(*)How to define new template in {@code IcingaUdt}</i><br />
 * <div style="border: #606060 solid 1px; margin: 10px 10px 10px 10px; padding: 4px 4px 4px 4px; font-size: 4px;">
 *     <ul>
 *         <li>Define a constant that identify the template. <i>i.e. public static final int NEW_CONSTANT=1000;</i></li>
 *         <li>Add a case in switch case block. <i>i.e. case NEW_CONSTANT: break; // Don't forget 'break;'</i></li>
 *         <li>Create new parameter string as showing above and assign to the 'result' variable. <i>i.e. result=...</i></li>
 *     </ul>
 * </div>
 *
 * +After we have the parameter string, pass it to {@code IcingaApi} and get the list of result.<br /><br />
 *
 * <h3>What happens when we pass the parameter string to {@code IcingaApi}?</h3>
 * {@code IcingaApi} will pass the parameter string to {@code IcingaExecutor}.
 * {@code IcingaExecutor} will send request to server and get the response string and return to {@code IcingaApi}.
 * {@code IcingaApi} will process the return string to get list of target and store in a {@code List<Map<String, Object>>}.
 *
 * <h1>Process the response</h1>
 * I highly recommend to use "xml" as the return type because of its convenience.<br />
 * We will analyse this return message:
 * <div style="border: #606060 solid 1px; margin: 10px 10px 10px 10px; padding: 4px 4px 4px 4px; font-size: 4px;">
 *     <pre>{@code
 *     <results>
 *     <result>
 *     <column name="SERVICE_ID">295</column>
 *     <column name="SERVICE_OBJECT_ID">139</column>
 *     <column name="SERVICE_IS_ACTIVE">1</column>
 *     <column name="SERVICE_INSTANCE_ID">1</column>
 *     <column name="SERVICE_NAME">MailQ</column>
 *     <column name="SERVICE_DISPLAY_NAME">MailQ</column>
 *     <column name="SERVICE_OUTPUT">Error occured:error=1:0:0</column>
 *     <column name="SERVICE_PERFDATA"></column>
 *     </result>
 *     <result>
 *     <column name="SERVICE_ID">311</column>
 *     <column name="SERVICE_OBJECT_ID">155</column>
 *     <column name="SERVICE_IS_ACTIVE">1</column>
 *     <column name="SERVICE_INSTANCE_ID">1</column>
 *     <column name="SERVICE_NAME">POP3</column>
 *     <column name="SERVICE_DISPLAY_NAME">POP3</column>
 *     <column name="SERVICE_OUTPUT">Verbindungsaufbau abgelehnt</column>
 *     <column name="SERVICE_PERFDATA"></column>
 *     </result>
 *     <total>2</total>
 *     </results>}</pre>
 * </div>
 * The root tag ({@code<results></results>}) contains list of target. Each tag {@code<result></result>}
 * is a target. Each target, we will store in a map, each column name is a key, and column value is
 * the value of that key. For example: {@code Map<"SERVICE_ID", 295>}<br />
 * If any error is encountered, there will be a tag pair named {@code<error></error>}
 * @author MinhNN
 */
package mhst.dreamteam.Icinga;