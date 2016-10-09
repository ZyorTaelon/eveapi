package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.TitleWithRoles;
import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.response.corporation.TitlesResponse;

public class TitlesHandler extends AbstractContentListHandler<TitlesResponse, TitleWithRoles> {
    private RolesHandler<ApiResponse> roleHandler = new RolesHandler<>();
    private TitleWithRoles title;

    public TitlesHandler() {
        super(TitlesResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            roleHandler.parseRowsetRoles(name);
        } else if (ELEMENT_ROW.equals(qName)) {
            if (!roleHandler.handleTitleRoles(title, attrs)) {
                title = getItem(attrs);
                getResponse().add(title);
            }
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    @Override
    protected TitleWithRoles getItem(final Attributes attrs) {
        final TitleWithRoles item = new TitleWithRoles();
        saveFieldsCount(TitleWithRoles.class, attrs);
        item.setTitleID(getLong(attrs, "titleID"));
        item.setTitleName(getString(attrs, "titleName"));
        return item;
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            roleHandler.resetRoles();
        }
        super.endElement(uri, localName, qName);
    }
}
