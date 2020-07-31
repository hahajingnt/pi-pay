package com.jackrain.pay.pi.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jackrain.pay.exception.PayRunTimeException;
import com.jackrain.pay.utils.AlipayUtils;
import com.jackrain.pay.utils.MD5Utils;
import com.jackrain.pay.utils.SortHashtable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2019/11/25
 * create at : 2019/11/25 11:13 AM
 *
 */
@Data
@Slf4j
public class PiPayEntity {

    private String payWay;

    private String developerId;

    private String developerKey;

    private String timestamp;

    private String sign;

    private String notifyUrl;

    private String redirectUrl;

    public void setSignWithMap(Map<String, String> params){

        if (StringUtils.isEmpty(getDeveloperId())){
            setDeveloperId("");
        }
        if (StringUtils.isEmpty(getDeveloperKey())){
            throw new PayRunTimeException("developerKey不能为空");
        }
//        if (StringUtils.isEmpty(getTimestamp())){
//            throw new PayRunTimeException("timestamp不能为空");
//        }
        //第一步，拼接 developer_id、developer_key、time_stamp 组 成 [developer_id]+[developer_key]+[time_stamp]字符串，经过md5运算得到字符串subSign1
        String timestamp = getTimestamp() == null?"":getTimestamp();
        String des = getDeveloperId()+ getDeveloperKey() + timestamp;
        log.info("des:" + des);
        String subSign1 = MD5Utils.MD5Encode(des,"utf-8");
        log.info("subSign1:" + subSign1);
        //第二步，将 param“key:value”组按照 key 的 ACSII 码的从小到大排序，然后将所有 key 和 value 拼接组成形如 “key1=value1&key2=value2”的字符串 paramStr
        //过滤掉空值
        params = AlipayUtils.paraFilter(params);
        //有明细也得排序
        if(params.get("goods_detail") != null){
            JSONArray jsonArray= JSON.parseArray(params.get("goods_detail"));
            for(int i=0;i<jsonArray.size();i++){
                JSONObject jsonObject=sortedJSONObejct(jsonArray.getJSONObject(i));
                jsonArray.set(i,jsonObject);
            }
            params.put("goods_detail",jsonArray.toJSONString());
        }

        //拼接字符串
        String paramStr = AlipayUtils.createLinkString(params);
        log.info("paramStr:" + paramStr);
        //第三步，拼接 subSign1、paramStr、notifyUrl、redirect_url 组成 [subSign1] + [paramStr] + [notifyUrl]+ [redirect_url] 字符串，再次经过 md5 最终得到签名 sign
        des = subSign1 + paramStr;
        if (getNotifyUrl() != null){
            des += getNotifyUrl();
        }
        if (getRedirectUrl() != null){
            des += getRedirectUrl();
        }
        log.info("des:" + des);
        String sign = MD5Utils.MD5Encode(des,"utf-8");
        log.info("sign:" + sign);
        setSign(sign);
    }

    /*
     * 对JSON对象里面的元素排序
     * */
    public static JSONObject sortedJSONObejct(JSONObject param){
        Hashtable hashtable = new Hashtable();
        param.keySet().forEach(p -> {
            String paramValue = param.getOrDefault(p, "").toString();
            if (!StringUtils.isEmpty(paramValue)) {
                hashtable.put(p, paramValue);
            }
        });
        Map.Entry[] sortHashtable = SortHashtable.getSortedHashtableByKey(hashtable);
        JSONObject jsonObject=new JSONObject(true);
        for (int i = 0; i < sortHashtable.length; i++) {
            jsonObject.put(sortHashtable[i].getKey().toString(),sortHashtable[i].getValue());
        }
        return jsonObject;
    }

    /**
     * 该签名用于下载对账单
     * @param params 用于签名的参数
     * @return 返回用于签名的字符串,字符串按照key1=value1&key2=value2格式,key的ASCII码顺序升序排序
     * */
    public static String getSignString(JSONObject params,String developerKey){
        Hashtable hashtable = new Hashtable();
        params.keySet().forEach(p -> {
            String paramValue = params.getOrDefault(p, "").toString();
            if (!StringUtils.isEmpty(paramValue) && !"sign".equalsIgnoreCase(p.toString())) {
                hashtable.put(p, paramValue);
            }
        });

        String sign = "";
        Map.Entry[] sortHashtable = SortHashtable.getSortedHashtableByKey(hashtable);
        for (int i = 0; i < sortHashtable.length; i++) {
            sign += (sortHashtable[i].getKey() + "=" + sortHashtable[i].getValue() + "&");
        }
        //去掉最后面的&
        sign=developerKey+sign.substring(0,sign.length()-1);

        return sign;
    }
}
