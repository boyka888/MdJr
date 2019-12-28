/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.trans.http;

import com.md.client.trans.Lang;

/**
 *
 * @author tangyue
 * @version $Id: IHttpParams.java, v 0.1 2019-12-04 9:31 tangyue Exp $$
 */
public interface IHttpParams {
    /**
     * Set the request parameters that will be sent to the server.
     * @param source source language
     * @param text the content to be convert to speech
     */
    public void setFormData(Lang source, String text);

    /**
     * Set the request parameters that will be sent to the server.
     * @param from source language
     * @param to target language
     * @param text the content to be translated
     */
    public void setFormData(Lang from, Lang to, String text);
}
