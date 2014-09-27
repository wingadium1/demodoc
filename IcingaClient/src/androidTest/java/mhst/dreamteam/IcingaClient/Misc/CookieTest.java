package mhst.dreamteam.IcingaClient.Misc;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

import mhst.dreamteam.IcingaClient.GlobalConst;
import mhst.dreamteam.IcingaClient.Interface.OnCompleteListener;
import mhst.dreamteam.IcingaClient.SessionMng.Session;

/**
 * Created by dynamo on 9/26/14.
 */
public class CookieTest extends AndroidTestCase {


    @LargeTest
    public void testBuild_Null() {
        Assert.assertNull( CookieMng.build(new HashMap()));
    }

    @LargeTest
    public void testBuild_One_Null() {
        Map<String,String> map = new HashMap();
        map.put(null,null);
        Exception ex = null;
        try{
            CookieMng.build(map);
        }
        catch (Exception e) {
            ex = e;
        }
        Assert.assertTrue(ex instanceof NullPointerException);
    }

    @LargeTest
    public void testBuild_One_Normal() {
        Map<String,String> map = new HashMap();
        map.put("host","google.com.vn");
        Assert.assertEquals("host=google.com.vn;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_Normal_WithSpaceStartEnd() {
        Map<String,String> map = new HashMap();
        map.put(" host "," google.com.vn ");
        Assert.assertEquals("host=google.com.vn;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_Normal_WithSpaceStart() {
        Map<String,String> map = new HashMap();
        map.put(" host"," google.com.vn");
        Assert.assertEquals("host=google.com.vn;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_Normal_WithSpaceEnd() {
        Map<String,String> map = new HashMap();
        map.put("host ","google.com.vn ");
        Assert.assertEquals("host=google.com.vn;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_Normal_WithSemicolon() {
        Map<String,String> map = new HashMap();
        map.put("host;","google.com.vn");
        Assert.assertEquals("host=google.com.vn;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_Normal_WithEqualsign() {
        Map<String,String> map = new HashMap();
        map.put("host=","google.com.vn");
        Assert.assertEquals("host=google.com.vn;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_EmptyAll() {
        Map<String,String> map = new HashMap();
        map.put("","");
        Assert.assertEquals("", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_OnlyKeyEmpty() {
        Map<String,String> map = new HashMap();
        map.put("","not empty");
        Assert.assertEquals("", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_One_OnlyValueEmpty() {
        Map<String,String> map = new HashMap();
        map.put("host","");
        Assert.assertEquals("host=;", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_More_Normal() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host","google.com.vn"},
                {"name","dynamo"},
                {"pass","123456"},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);
        map.put(mapStr[2][0],mapStr[2][1]);

        int length = 0;
        String result = CookieMng.build(map);
        for(String[] afield: mapStr) {
            Assert.assertTrue(result.contains(afield[0] + "=" + afield[1] + ";"));
            length += afield[0].length()+afield[1].length() + 2;
        }
        Assert.assertEquals(length,result.length());
    }

    @LargeTest
    public void testBuild_More_Normal_WithSpace() {

        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {" host "," google.com.vn "},
                {" name"," dynamo"},
                {"pass ","123456 "},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);
        map.put(mapStr[2][0],mapStr[2][1]);

        int length = 0;
        String result = CookieMng.build(map);
        for(String[] afield: mapStr) {
            Assert.assertTrue(result.contains(afield[0].trim() + "=" + afield[1].trim() + ";"));
            length += afield[0].trim().length()+afield[1].trim().length() + 2;
        }
        Assert.assertEquals(length,result.length());
    }

    @LargeTest
    public void testBuild_More_Normal_WithSpecialChar() {

        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host;","=google.com.vn"},
                {"name=",";dynamo"},
                {" pass "," 123456 "},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);
        map.put(mapStr[2][0],mapStr[2][1]);

        int length = 0;
        String result = CookieMng.build(map);
        for(String[] afield: mapStr) {
            Assert.assertTrue(result.contains(CookieMng.removeSpecial(afield[0]) + "=" + CookieMng.removeSpecial(afield[1]) + ";"));
            length += CookieMng.removeSpecial(afield[0]).length()+CookieMng.removeSpecial(afield[1]).length() + 2;
        }
        Assert.assertEquals(length,result.length());
    }

    @LargeTest
    public void testBuild_More_EmptyAll() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"",""},
                {"",""},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);
        Assert.assertEquals("", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_More_AllKeyEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"","google.com.vn"},
                {"","dynamo"},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);
        Assert.assertEquals("", CookieMng.build(map));
    }

    @LargeTest
    public void testBuild_More_AllValueEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host",""},
                {"name",""},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);

        int length = 0;
        String result = CookieMng.build(map);
        for(String[] afield: mapStr) {
            Assert.assertTrue(result.contains(afield[0] + "=" + afield[1] + ";"));
            length += afield[0].length()+afield[1].length() + 2;
        }
        Assert.assertEquals(length,result.length());
    }

    @LargeTest
    public void testBuild_More_OneKeyEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host","google.com.vn"},
                {"","dynamo"},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);

        int length = 0;
        String result = CookieMng.build(map);
        for(String[] afield: mapStr) {
            if(afield[0] != "") {
                Assert.assertTrue(result.contains(afield[0] + "=" + afield[1] + ";"));
                length += afield[0].length() + afield[1].length() + 2;
            }
        }
        Assert.assertEquals(length,result.length());
    }

    @LargeTest
    public void testBuild_More_OneValueEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host",""},
                {"name","dynamo"},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);

        int length = 0;
        String result = CookieMng.build(map);
        for(String[] afield: mapStr) {
            Assert.assertTrue(result.contains(afield[0] + "=" + afield[1] + ";"));
            length += afield[0].length()+afield[1].length() + 2;
        }
        Assert.assertEquals(length,result.length());
    }

    @LargeTest
    public void testParse_Null() {
        Assert.assertNull( CookieMng.parse(null));
    }

    @LargeTest
    public void testParse_Empty() {
        Assert.assertNull( CookieMng.parse(""));
    }

    @LargeTest
    public void testParse_One_Normal() {
        Map<String,String> map = new HashMap();
        map.put("host","google.com.vn");
        Assert.assertEquals(map, CookieMng.parse("host=google.com.vn;"));
    }

    @LargeTest
    public void testParse_One_Normal_WithSpaceStartEnd() {
        Map<String,String> map = new HashMap();
        map.put("host","google.com.vn");
        Assert.assertEquals(map, CookieMng.parse(" host = google.com.vn ;"));
    }

    @LargeTest
    public void testParse_One_Normal_WithSpaceStart() {
        Map<String,String> map = new HashMap();
        map.put("host","google.com.vn");
        Assert.assertEquals(map, CookieMng.parse(" host= google.com.vn;"));
    }

    @LargeTest
    public void testParse_One_Normal_WithSpaceEnd() {
        Map<String,String> map = new HashMap();
        map.put("host","google.com.vn");
        Assert.assertEquals(map, CookieMng.parse("host =google.com.vn ;"));
    }

    @LargeTest
    public void testParse_One_OnlyKey() {
        Map<String,String> map = new HashMap();
        map.put("host","");
        Assert.assertEquals(map, CookieMng.parse("host=;"));
    }

    @LargeTest
    public void testParse_One_OnlyValue() {
        Map<String,String> map = new HashMap();
        Assert.assertEquals(map, CookieMng.parse("=google.com.vn;"));
    }

    @LargeTest
    public void testParse_One_WrongFormat_Semicolon() {
        Map<String,String> map = new HashMap();
        map.put("host","");
        Assert.assertNotSame(map,CookieMng.parse("host=,"));
        Assert.assertNotSame(map,CookieMng.parse("host="));
    }

    @LargeTest
    public void testParse_One_WrongFormat_Equalsign() {
        Map<String,String> map = new HashMap();
        map.put("host","");
        Assert.assertNotSame(map,CookieMng.parse("host;"));
    }

    @LargeTest
    public void testParse_More_Normal() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host","google.com.vn"},
                {"pass","123456"},
                {"name","dynamo"},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);
        map.put(mapStr[2][0],mapStr[2][1]);

        String input = "";
        for(String[] afield: mapStr)
            input += afield[0] + "=" + afield[1] + ";";
        Assert.assertEquals(map, CookieMng.parse(input));
    }

    @LargeTest
    public void testParse_More_Normal_WithSpace() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {" host "," google.com.vn "},
                {" pass","123456 "},
                {"name "," dynamo"},
        };
        map.put(mapStr[0][0].trim(),mapStr[0][1].trim());
        map.put(mapStr[1][0].trim(),mapStr[1][1].trim());
        map.put(mapStr[2][0].trim(),mapStr[2][1].trim());

        String input = "";
        for(String[] afield: mapStr)
            input += afield[0] + "=" + afield[1] + ";";
        Assert.assertEquals(map, CookieMng.parse(input));
    }

    @LargeTest
    public void testParse_More_EmptyAll() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"",""},
                {"",""},
        };

        String input = "";
        for(String[] afield: mapStr)
            input += afield[0] + "=" + afield[1] + ";";
        Assert.assertEquals(map, CookieMng.parse(input));
    }

    @LargeTest
    public void testParse_More_AllValueEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host",""},
                {"name",""},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);

        String input = "";
        for(String[] afield: mapStr)
            input += afield[0] + "=" + afield[1] + ";";
        Assert.assertEquals(map, CookieMng.parse(input));
    }

    @LargeTest
    public void testParse_More_AllKeyEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"","google.com.vn"},
                {"","dynamo"},
        };

        String input = "";
        for(String[] afield: mapStr)
            input += afield[0] + "=" + afield[1] + ";";
        Assert.assertEquals(map, CookieMng.parse(input));
    }

    @LargeTest
    public void testParse_More_OneKeyEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host","google.com.vn"},
                {"","dynamo"},
        };

        String input = "";
        for(String[] afield: mapStr) {
            input += afield[0] + "=" + afield[1] + ";";
            if(!afield[0].isEmpty())
                map.put(afield[0],afield[1]);
        }
        Assert.assertEquals(map, CookieMng.parse(input));
    }

    @LargeTest
    public void testParse_More_OneValueEmpty() {
        Map<String,String> map = new HashMap();
        String[][] mapStr = {
                {"host",""},
                {"name","dynamo"},
        };
        map.put(mapStr[0][0],mapStr[0][1]);
        map.put(mapStr[1][0],mapStr[1][1]);

        String input = "";
        for(String[] afield: mapStr)
            input += afield[0] + "=" + afield[1] + ";";
        Assert.assertEquals(map, CookieMng.parse(input));
    }
}
