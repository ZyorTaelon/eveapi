package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.OutpostServiceDetail;
import com.beimin.eveapi.response.corporation.OutpostServiceDetailResponse;

public class OutpostServiceDetailHandler extends AbstractContentListHandler<OutpostServiceDetailResponse, OutpostServiceDetail> {
    public OutpostServiceDetailHandler() {
        super(OutpostServiceDetailResponse.class);
    }

    @Override
    protected OutpostServiceDetail getItem(final Attributes attrs) {
        final OutpostServiceDetail item = new OutpostServiceDetail();
        saveAttributes(OutpostServiceDetail.class, attrs);
        item.setStationID(getLong(attrs, "stationID"));
        item.setOwnerID(getLong(attrs, "ownerID"));
        item.setServiceName(getString(attrs, "serviceName"));
        item.setMinStanding(getDouble(attrs, "minStanding"));
        item.setSurchargePerBadStanding(getDouble(attrs, "surchargePerBadStanding"));
        item.setDiscountPerGoodStanding(getDouble(attrs, "discountPerGoodStanding"));
        return item;
    }
}
