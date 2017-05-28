package me.zero.client.api.command.parse.defaults;

import me.zero.client.api.command.parse.ArgumentParser;

/**
 * Parses a number (Represented by a Double)
 *
 * @author Brady
 * @since 2/13/2017 12:00 PM
 */
@Deprecated
public final class NumberParser implements ArgumentParser<Double> {

    @Override
    public Double apply(String t) {
        try {
            return Double.parseDouble(t);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
