/*
 *  OmegaT - Computer Assisted Translation (CAT) tool
 *           with fuzzy matching, translation memory, keyword search,
 *           glossaries, and translation leveraging into updated projects.
 *
 *  Copyright (C) 2012 Alex Buloichik, Didier Briel
 *                2016-2017 Aaron Madlon-Kay
 *                2018 Didier Briel
 *                2022,2023 Hiroshi Miura
 *                Home page: https://www.omegat.org/
 *                Support center: https://omegat.org/support
 *
 *  This file is part of OmegaT.
 *
 *  OmegaT is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  OmegaT is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.omegat.connectors.machinetranslators.mtuoc;

import org.omegat.util.Language;

/**
 * Support for Microsoft Translator API machine translation.
 *
 * @author Alex Buloichik (alex73mail@gmail.com)
 * @author Didier Briel
 * @author Aaron Madlon-Kay
 *
 * @see <a href="https://www.microsoft.com/en-us/translator/translatorapi.aspx">Translator API</a>
 * @see <a href="https://docs.microsofttranslator.com/text-translate.html">Translate Method reference</a>
 */
public abstract class MtuocTranslatorBase {

    protected final MtuocPlugin parent;

    public MtuocTranslatorBase(MtuocPlugin parent) {
        this.parent = parent;
    }



    /**
     * translate text.
     * @param sLang source langauge.
     * @param tLang target language.
     * @param text source text.
     * @return translated text.
     * @throws Exception when connection error.
     */
    protected synchronized String translate(Language sLang, Language tLang, String text) throws Exception {
        //Languages are not currently used in MTUOC, but keep these for later use
        String langFrom = sLang.getLanguage();
        String langTo = tLang.getLanguage();
        return requestTranslate(langFrom, langTo, text);
    }

    protected abstract String requestTranslate(String langFrom, String langTo, String text) throws Exception;
}
