package com.sx.common.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("ep")
@Component
@Data
public class EpProperties {
  private Cfg cfg;

  @Data
  public static class Cfg{
    private String[] corsOrigins;
  }
}
