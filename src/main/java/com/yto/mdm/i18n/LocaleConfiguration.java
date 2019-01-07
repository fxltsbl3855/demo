package com.yto.mdm.i18n;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class LocaleConfiguration {

    private class LangLocaleResolver implements LocaleResolver {
        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String lang = request.getParameter("lang");
            Locale locale = Locale.getDefault();
            if (!StringUtils.isEmpty(lang)) {
                String[] split = lang.split("_");
                locale = new Locale(split[0], split[1]);
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
            request.getSession().setAttribute("lang", this.resolveLocale(request));
        }
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new LangLocaleResolver();
    }

}
