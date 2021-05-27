package com.easylearning.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLogingFilter extends ZuulFilter {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        //type is pre, post, error
        return "pre";
    }

    @Override
    public int filterOrder() {
        //if there is multple filter then we can set the priority
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        logger.info("Request uri {}  \naddress: {}", request.getRequestURI(), request.getLocalAddr());
        return null;
    }
}
