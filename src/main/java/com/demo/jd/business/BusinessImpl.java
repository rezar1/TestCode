package com.demo.jd.business;


import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.request.etms.LdopMiddleWaybillWaybill2CTraceApiRequest;
import com.jd.open.api.sdk.response.etms.LdopMiddleWaybillWaybill2CTraceApiResponse;

import java.util.Optional;

public class BusinessImpl extends AccesInfoHolder {

    public Optional<LdopMiddleWaybillWaybill2CTraceApiResponse> doReq(
            String accessToken,
            String trackeCode,
            String waybillCode) {
        JdClient client = new DefaultJdClient(
                _2cTraceApiUrl,
                accessToken,
                appKey,
                appSecret);
        LdopMiddleWaybillWaybill2CTraceApiRequest request =
                new LdopMiddleWaybillWaybill2CTraceApiRequest();
        request.setTradeCode(trackeCode);
        request.setWaybillCode(waybillCode);
        try {
            return Optional.ofNullable(client.execute(request));
        } catch (Exception e) {
            //do log
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
