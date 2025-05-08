package com.wexalian.jtrakt.util;

import com.wexalian.nullability.annotations.Nullable;

public final class Strings {
    public static boolean isNullOrEmpty(@Nullable String string) {
        return string == null || string.isEmpty();
    }
}
