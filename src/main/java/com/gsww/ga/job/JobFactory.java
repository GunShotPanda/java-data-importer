package com.gsww.ga.job;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * <b><code>JobFactory</code></b>
 * <p/>
 * JobFactory
 * <p/>
 * <b>Creation Time:</b> 2017/9/4 19:31.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@Component
public class JobFactory extends AdaptableJobFactory {

    /**
     * The Autowire capable bean factory.
     */
    private final AutowireCapableBeanFactory autowireCapableBeanFactory;

    /**
     * Instantiates a new Job factory.
     *
     * @param autowireCapableBeanFactory the autowire capable bean factory
     */
    @Autowired
    public JobFactory(AutowireCapableBeanFactory autowireCapableBeanFactory) {
        this.autowireCapableBeanFactory = autowireCapableBeanFactory;
    }

    /**
     * Create job instance object.
     *
     * @param bundle the bundle
     * @return the object
     * @throws Exception the exception
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }

}
