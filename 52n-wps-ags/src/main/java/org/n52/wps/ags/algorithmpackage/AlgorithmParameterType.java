/**
 * ﻿Copyright (C) 2009 - 2019 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *       • Apache License, version 2.0
 *       • Apache Software License, version 1.0
 *       • GNU Lesser General Public License, version 3
 *       • Mozilla Public License, versions 1.0, 1.1 and 2.0
 *       • Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.3-hudson-jaxb-ri-2.2.3-3-
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2011.02.08 at 05:49:57 PM MEZ
//


package org.n52.wps.ags.algorithmpackage;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Structure for a parameter description.
 *
 * <p>Java class for AlgorithmParameterType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AlgorithmParameterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prefixString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suffixString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="separatorString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="positionID" type="{}PositionIDType"/>
 *           &lt;element name="stringID" type="{}StringIDType"/>
 *         &lt;/choice>
 *         &lt;element name="wpsInputID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpsOutputID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlgorithmParameterType", propOrder = {
    "prefixString",
    "suffixString",
    "separatorString",
    "positionID",
    "stringID",
    "wpsInputID",
    "wpsOutputID"
})
public class AlgorithmParameterType {

    protected String prefixString;
    protected String suffixString;
    protected String separatorString;
    protected BigInteger positionID;
    protected String stringID;
    protected String wpsInputID;
    protected String wpsOutputID;

    /**
     * Gets the value of the prefixString property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrefixString() {
        return prefixString;
    }

    /**
     * Sets the value of the prefixString property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrefixString(String value) {
        this.prefixString = value;
    }

    /**
     * Gets the value of the suffixString property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSuffixString() {
        return suffixString;
    }

    /**
     * Sets the value of the suffixString property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSuffixString(String value) {
        this.suffixString = value;
    }

    /**
     * Gets the value of the separatorString property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSeparatorString() {
        return separatorString;
    }

    /**
     * Sets the value of the separatorString property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSeparatorString(String value) {
        this.separatorString = value;
    }

    /**
     * Gets the value of the positionID property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPositionID() {
        return positionID;
    }

    /**
     * Sets the value of the positionID property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPositionID(BigInteger value) {
        this.positionID = value;
    }

    /**
     * Gets the value of the stringID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStringID() {
        return stringID;
    }

    /**
     * Sets the value of the stringID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStringID(String value) {
        this.stringID = value;
    }

    /**
     * Gets the value of the wpsInputID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWpsInputID() {
        return wpsInputID;
    }

    /**
     * Sets the value of the wpsInputID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWpsInputID(String value) {
        this.wpsInputID = value;
    }

    /**
     * Gets the value of the wpsOutputID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWpsOutputID() {
        return wpsOutputID;
    }

    /**
     * Sets the value of the wpsOutputID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWpsOutputID(String value) {
        this.wpsOutputID = value;
    }

}
