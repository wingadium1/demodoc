package mhst.dreamteam.IcingaClient.Icinga;

import mhst.dreamteam.IcingaClient.GlobalConfig;

/**
 * Icinga parameter to request to server include:<br />
 * +TARGET (required) // Which field to request, is a simple string like host<br />
 * +COLUMNS (required) // A listing of columns to return, must look like this: columns[COL1|COL2|COL3|...]<br />
 * +FILTER // Defines which filters to use in the request. Must always be nested in AND or OR groups
 * +ORDER // Defines which field to use for ordering and if ascending or descending ordering should be used. Example: order[COLUMN| ASC or DESC]<br />
 * +GROUPING // Defines a field to group by: group[COL]<br />
 * +LIMIT // Defines a starting offset and/or a limit: limit[START;END ( if needed ) ]<br />
 * +COUNTFIELD // Adds a total field to the result which counts by this field (in most cases, the id): countColumn=COL<br />
 * +OUTPUT (required but can be null, default value added) json or xml<br />
 * After define target and filter, call method toString to convert parameter into String.<br />
 * (*)Remember: target and columns is required. Set target and columns before doing anything.
 *
 * @author MinhNN
 * @see mhst.dreamteam.IcingaClient.Icinga.IcingaConst
 */
public class IcingaParam {
    private String mTarget;
    private String mFilter;
    private String[] mColumn;
    private String mOrder;
    private String mGroup;
    private String mLimit;
    private String mCountField;
    private String mOutput;

    /**
     * Sets the target
     *
     * @param sTarget string target
     * @return current instance
     */
    public IcingaParam setTarget(String sTarget) {
        if (sTarget != null && !sTarget.isEmpty()) {
            mTarget = sTarget;
        }
        return this;
    }

    /**
     * Sets filters
     *
     * @param filter string filters. Each filter must be nested in AND/OR. Not included square brackets []<br />
     *               i.e. AND/OR(COLUMN|OPERATOR|VALUE;COLUMN2|OPERATOR2|VALUE2;OR(...))
     * @return current instance
     */
    public IcingaParam setFilters(String filter) {
        if (filter != null && !filter.isEmpty()) {
            mFilter = filter;
        }
        return this;
    }

    /**
     * Sets list of columns to show
     *
     * @param aColumn list of columns
     * @return current instance
     */
    public IcingaParam setColumns(String... aColumn) {
        if (aColumn != null && aColumn.length != 0) {
            mColumn = aColumn;
        }
        return this;
    }

    /**
     * Sets list of columns to show.
     *
     * @param sColumn list of columns. Not included quare brackets.<Br />
     *                i.e. COLUMN_NAME // for single column
     *                COLUMN1_NAME|COLUMN2_NAME // for multi-columns
     * @return current instance
     */
    public IcingaParam setColumns(String sColumn) {
        if (sColumn != null && !sColumn.isEmpty()) {
            mColumn = sColumn.split("\\|");
        }
        return this;
    }

    /**
     * Sets column to sort via.
     *
     * @param sColumn   column to sort
     * @param sOrderVia asc for ascending or desc for descending
     * @return current instance
     */
    public IcingaParam setOrder(String sColumn, String sOrderVia) {
        if (sColumn != null && !sColumn.isEmpty()) {
            mOrder = "[" + sColumn + ((sOrderVia != null && !sOrderVia.isEmpty()) ? "|" + sOrderVia : "|ASC") + "]";
        }
        return this;
    }

    /**
     * Sets grouping column
     *
     * @param sGroup column to group by
     * @return current instance
     */
    public IcingaParam setGroup(String sGroup) {
        if (sGroup != null && !sGroup.isEmpty()) {
            mGroup = "[" + sGroup + "]";
        }
        return this;
    }

    /**
     * Sets the offset to start and the limitation of the result.
     *
     * @param nStart where the result start
     * @param nEnd   the limit of the result
     * @return current instance
     */
    public IcingaParam setLimit(int nStart, int nEnd) {
        if (nStart > -1 && nStart <= nEnd) {
            mLimit = "[" + nStart + ";" + nEnd + "]";
        }
        return this;
    }

    /**
     * Sets the offset to start of the result.
     *
     * @param nOffset where the result start
     * @return current instance
     */
    public IcingaParam setLimit(int nOffset) {
        if (nOffset > -1) {
            mLimit = "[" + nOffset + "]";
        }
        return this;
    }

    /**
     * Sets count field.
     *
     * @param sColumn column to count.
     * @return current instance
     */
    public IcingaParam setCountField(String sColumn) {
        if (sColumn != null && !sColumn.isEmpty()) {
            mCountField = sColumn;
        }
        return this;
    }

    /**
     * Override the output type. Default value declare in GlobalConfig class.
     *
     * @param sOutput xml or json
     * @return current instance
     * @see mhst.dreamteam.IcingaClient.GlobalConfig
     */
    public IcingaParam setOutput(String sOutput) {
        if (sOutput != null && !sOutput.isEmpty()) {
            mOutput = sOutput;
        }
        return this;
    }

    /**
     * Parses list of columns into string
     *
     * @param aColumn list of column
     * @return string to use in request
     */
    private static String parseColumn(String... aColumn) {
        if (aColumn == null || aColumn.length == 0) return "";

        String sColumns = "[";

        for (String s : aColumn) {
            sColumns += s + "|";
        }

        sColumns = sColumns.substring(0, sColumns.length() - 1) + "]";

        return sColumns;
    }

    @Override
    public String toString() {
        String result = "/";

        // If there is no target, return nothing
        if (mTarget == null || mColumn == null || parseColumn(mColumn).isEmpty()) {
            return null;
        }

        // Add target and columns
        result += mTarget + "/columns" + parseColumn(mColumn);

        // Add filter
        if (mFilter != null) {
            result += "/filter" + mFilter;
        }

        // Add order
        if (mOrder != null) {
            result += "/order" + mOrder;
        }

        // Add group
        if (mGroup != null) {
            result += "/group" + mGroup;
        }

        // Add limit
        if (mLimit != null) {
            result += "/limit" + mLimit;
        }

        // Add countColumn
        if (mCountField != null) {
            result += "/countColumn=" + mCountField;
        }

        // Override output
        if (mOutput != null) {
            result += "/" + mOutput;
        } else {
            result += "/" + GlobalConfig.returnType;
        }

        return result;
    }
}
