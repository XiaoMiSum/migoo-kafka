/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021.  Lorem XiaoMiSum (mi_xiao@qq.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * 'Software'), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package protocol.xyz.migoo.kafka.sampler;

import com.alibaba.fastjson.JSONObject;
import core.xyz.migoo.samplers.SampleResult;
import core.xyz.migoo.testelement.MiGooProperty;
import protocol.xyz.migoo.kafka.util.KafkaConstantsInterface;

/**
 * @author mi.xiao
 * @date 2021/4/13 14:44
 */
public class KafkaSampleResult extends SampleResult implements KafkaConstantsInterface {
    
    private static final long serialVersionUID = 2310775168348233456L;

    public KafkaSampleResult(String title) {
        super(title);
    }

    public void setRequestData(MiGooProperty property) {
        JSONObject config = (JSONObject) property.getOrDefault("config", new JSONObject());
        config.putIfAbsent(BOOTSTRAP_SERVERS_CONFIG, property.get(BOOTSTRAP_SERVERS_CONFIG));
        config.putIfAbsent(ACKS_CONFIG, property.get(ACKS_CONFIG));
        config.putIfAbsent(RETRIES_CONFIG, property.get(RETRIES_CONFIG));
        config.putIfAbsent(LINGER_MS_CONFIG, property.get(LINGER_MS_CONFIG));
        config.putIfAbsent(KEY_SERIALIZER_CLASS_CONFIG, property.get(KEY_SERIALIZER_CLASS_CONFIG));
        config.putIfAbsent(VALUE_SERIALIZER_CLASS_CONFIG, property.get(VALUE_SERIALIZER_CLASS_CONFIG));
        super.setSamplerData(config.toString());
    }

}
