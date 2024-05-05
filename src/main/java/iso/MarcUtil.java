package iso;


import java.io.*;
import java.util.*;

/**
 * marc.iso文件处理
 *
 * @author chengs
 * @date 2019-12-02
 */
public class MarcUtil {

    /**
     * 分行读取marc.iso文件返回List<String>类型数据
     *
     * @return
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("D:\\编目ISO\\2403-001_19-010.ISO");

        Reader reader = null;
        try {
            reader = new InputStreamReader(fis, "GBK");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(reader);
        List<String> marcStrList = new ArrayList<>();
        String str = null;
        while (true) {
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (str != null) {
                marcStrList.add(str);
            } else {
                break;
            }
        }
        List<Map<String, Object>> maps = dealMarc(marcStrList);
        for (Map<String, Object> map : maps){
            Set<String> strings = map.keySet();
            for (String key : strings){
                System.out.println(key + ":" + map.get(key));
            }
            System.out.println("\n");
        }
    }

    public static List<Map<String, Object>> dealMarc(List<String> marcList) {
        List<Map<String, Object>> resultMapList = new ArrayList<>();
        for (String marcStr : marcList) {
            //截除尾标
            String marcDetail1 = marcStr.split("\\u001d")[0];
            String s1 = marcDetail1.split("\\u001e")[0];
            String s2 = (String) s1.subSequence(5, 6);
            if (s2.equals("d")) {
                System.err.println("检测到数据已废除！错误发生在：标识区状态为‘d’");
            }
            int index = Integer.parseInt(s1.substring(12, 17));
            String s4 = s1.substring(24, index - 1);
            if (s4.length() % 12 != 0) {
                System.err.println("检测到数据格式错误！错误发生在：地址目次区");
            }
            //目次区集合
            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < s4.length() / 12; i++) {
                list1.add(s4.substring(12 * i, 12 * (i + 1)));
            }
            //第一个数组是标识+目次区
            int k = marcDetail1.split("\\u001E").length - 1;
            String[] sz = marcDetail1.split("\\u001E");
            //记录区集合
            List<String> list2 = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                list2.add(sz[i + 1]);
            }
            if (list1.size() != list2.size()) {
                System.err.println("检测到目次区与记录区数量不匹配！错误发生在：目次区或数据区，"
                        + "目次区：" + list1.size() + "组，记录区：" + list2.size() + "条");
            }
            //字段存储map
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < list1.size(); i++) {
                map = matchField(list1.get(i).substring(0, 3), list2.get(i), map);
            }
            resultMapList.add(map);
        }
        return resultMapList;
    }

    /**
     * 匹配字段 (Metadata.class)
     *
     * @param key1 目次
     * @param key2 记录
     * @param map  实体类map
     * @return
     */
    public static Map<String, Object> matchField(String key1, String key2, Map map) {
        switch (key1) {
            case "010":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("isbn") == null) {
                        map.put("isbn", value);
                    }
                }
                if (key2.split("\\u001Fd").length > 1) {
                    String value = key2.split("\\u001Fd")[1].split("\\u001F")[0];
                    if (map.get("price") == null) {
                        map.put("price", value);
                    }
                }
                break;
            case "011":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("issn") == null) {
                        map.put("issn", value);
                    }
                }
                if (key2.split("\\u001Fd").length > 1) {
                    String value = key2.split("\\u001Fd")[1].split("\\u001F")[0];
                    if (map.get("price") == null) {
                        map.put("price", value);
                    }
                }
                break;
            case "012":
                if (key2.split("\\u001F5").length > 1) {
                    String value = key2.split("\\u001F5")[1].split("\\u001F")[0];
                    if (map.get("applyObject") == null) {
                        map.put("applyObject", value);
                    }
                }
                break;
            case "020":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("booRecNo") == null) {
                        map.put("booRecNo", value);
                    }
                }
                break;
            case "101":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("language") == null) {
                        map.put("language", value);
                    }
                    if (map.get("aggLanguage") == null) {
                        map.put("aggLanguage", value);
                    }
                }
                break;
            case "102":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("country") == null) {
                        map.put("country", value);
                    }
                }
                break;
            case "200":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("title") == null) {
                        map.put("title", value);
                    }
                }

                if (key2.split("\\u001Fc").length > 1) {
                    String value = key2.split("\\u001Fc")[1].split("\\u001F")[0];
                    if (map.get("otherTitle") == null) {
                        map.put("otherTitle", value);
                    }
                }
                if (key2.split("\\u001Fe").length > 1) {
                    String value = key2.split("\\u001Fe")[1].split("\\u001F")[0];
                    if (map.get("otherTitle") == null) {
                        map.put("otherTitle", value);
                    }
                }
                if (key2.split("\\u001Ff").length > 1) {
                    String value = key2.split("\\u001Ff")[1].split("\\u001F")[0];
                    if (map.get("author") == null) {
                        map.put("author", value);
                    }
                    if (map.get("aggAuthor") == null) {
                        map.put("aggAuthor", value);
                    }
                }
                break;
            case "210":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("publishLocation") == null) {
                        map.put("publishLocation", value);
                    }
                }
                if (key2.split("\\u001Fc").length > 1) {
                    String value = key2.split("\\u001Fc")[1].split("\\u001F")[0];
                    if (map.get("publisher") == null) {
                        map.put("publisher", value);
                    }
                    if (map.get("aggPublisher") == null) {
                        map.put("aggPublisher", value);
                    }
                }
                if (key2.split("\\u001Fd").length > 1) {
                    String value = key2.split("\\u001Fd")[1].split("\\u001F")[0];
                    if (map.get("jobYear") == null) {
                        Number num = Float.parseFloat(value) * 10;
                        Integer jobYear = Integer.valueOf(num.intValue() / 10) / 10;
                        map.put("jobYear", jobYear);
                    }
                }
                break;
            case "215":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("page") == null) {
                        map.put("page", value);
                    }
                }
                break;
            case "330":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("profile") == null) {
                        map.put("profile", value);
                    }
                }
                break;
            case "801":
                if (key2.split("\\u001Fb").length > 1) {
                    String value = key2.split("\\u001Fb")[1].split("\\u001F")[0];
                    if (map.get("company") == null) {
                        map.put("company", value);
                    }
                }
                break;
            case "333":
                if (key2.split("\\u001Fa").length > 1) {
                    String value = key2.split("\\u001Fa")[1].split("\\u001F")[0];
                    if (map.get("otherAuthor") == null) {
                        map.put("otherAuthor", value);
                    }
                }
                break;
//            case "606":
//                if (key2.split("\\u001Fa").length > 1) {
//                    String f1 = key2.split("\\u001Fa")[1];
//                    String f2 = f1.split("\\u001F")[0];
//                    map.put("type", f2);
//                }
//                break;
//            case "690":
//                if (key2.split("\\u001Fa").length > 1) {
//                    String f1 = key2.split("\\u001Fa")[1];
//                    String f2 = f1.split("\\u001F")[0];
//                    map.put("clc", f2);
//                }
//                break;
            //701
            //801
            //905
            default:
        }
        return map;
    }

}

