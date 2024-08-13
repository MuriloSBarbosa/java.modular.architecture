package com.murilobarbosa.java.modular.architecture.utils;

import com.github.database.rider.core.replacers.Replacer;
import org.dbunit.dataset.ReplacementDataSet;

public class RegexUUIDReplacer implements Replacer {

    @Override
    public void addReplacements(ReplacementDataSet replacementDataSet) {
        replacementDataSet.addReplacementSubstring("{{uuid_regex}}",
              "regex:\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}");
    }
}
