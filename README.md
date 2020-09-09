# raincloud-pay

#### 介绍
移动支付

#### 集成引包


#### 配置文件
    //测试支付网关
    r3.pipay.url=https://test.pay2.piplus.cn
    r3.pipay.downbill.url=


#### 代码实例

    @Autowired
    PayApi payApi;

    //支付
    public void mircopay(){

        MircoPayEntity mircoPayEntity = new MircoPayEntity();
        mircoPayEntity.setDeveloperId("001");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        mircoPayEntity.setTimestamp(timestamp.toString());
        mircoPayEntity.setAuthCode("284089011704405656");
        mircoPayEntity.setBody("苹果");
        mircoPayEntity.setOutTradeNo("000000000001");
        mircoPayEntity.setTotalAmount(1);
        mircoPayEntity.setCustomerId("3A47E6D7573A05840E3613FB39E0DA84");
        mircoPayEntity.setStoreCode("001");
        payApi.mircopay(mircoPayEntity);

    }

    //支付查询
    public void orderquery(){

        OrderQueryEntity orderQueryEntity = new OrderQueryEntity();
        orderQueryEntity.setDeveloperId("001");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        orderQueryEntity.setTimestamp(timestamp.toString());
        orderQueryEntity.setTradeNo("2019112622001412545718949776");
        orderQueryEntity.setCustomerId("3A47E6D7573A05840E3613FB39E0DA84");
        orderQueryEntity.setStoreCode("001");
        payApi.orderquery(orderQueryEntity);

    }

    //退款
    public void refund(){

        RefundEntity refundEntity = new RefundEntity();
        refundEntity.setDeveloperId("001");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        refundEntity.setTimestamp(timestamp.toString());
        refundEntity.setOutTradeNo("000000000001");
        refundEntity.setOutRefundNo("1000300200001");
        refundEntity.setCustomerId("3A47E6D7573A05840E3613FB39E0DA84");
        refundEntity.setStoreCode("001");
        refundEntity.setRefundAmount(1);
        refundEntity.setTotalAmount(1);
        payApi.refund(refundEntity);

    }

    //二维码支付
    public void precreate(){

        PrecreateEntity precreateEntity = new PrecreateEntity();
        precreateEntity.setDeveloperId("001");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        precreateEntity.setTimestamp(timestamp.toString());
        precreateEntity.setPrecreateType(PrecreateType.ALIPAY.getValue());
        precreateEntity.setBody("苹果");
        precreateEntity.setOutTradeNo("000000000003");
        precreateEntity.setTotalAmount(1);
        precreateEntity.setCustomerId("3A47E6D7573A05840E3613FB39E0DA84");
        precreateEntity.setStoreCode("001");
        payApi.precreate(mircoPayEntity);

    }

    //撤销
    public void reverse(){

        ReverseEntity reverseEntity = new ReverseEntity();
        reverseEntity.setDeveloperId("001");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info(timestamp.toString());
        reverseEntity.setTimestamp(timestamp.toString());
        reverseEntity.setTradeNo("2019112622001412545718949776");
        reverseEntity.setCustomerId("3A47E6D7573A05840E3613FB39E0DA84");
        reverseEntity.setStoreCode("001");
        payApi.reverse(reverseEntity);

    }
