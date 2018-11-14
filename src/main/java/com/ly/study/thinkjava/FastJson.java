package com.ly.study.thinkjava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

class PayResult {
	private String ifaceVersion;	//默认1.2
	private String next;			//PM00001
	private Boolean ok;				//默认true
	private String responseTime;	//响应时间戳
	private Boolean safety;			//默认true
	private String responseJSON;
	private PayResultResponseJson json;
	
	
	public String getIfaceVersion() {
		return ifaceVersion;
	}

	public void setIfaceVersion(String ifaceVersion) {
		this.ifaceVersion = ifaceVersion;
	}


	public String getNext() {
		return next;
	}


	public void setNext(String next) {
		this.next = next;
	}



	public Boolean getOk() {
		return ok;
	}


	public void setOk(Boolean ok) {
		this.ok = ok;
	}


	public String getResponseTime() {
		return responseTime;
	}


	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}


	public Boolean getSafety() {
		return safety;
	}


	public void setSafety(Boolean safety) {
		this.safety = safety;
	}


	public String getResponseJSON() {
		return responseJSON;
	}


	public void setResponseJSON(String responseJSON) {
		this.responseJSON = responseJSON;
	}


	public PayResultResponseJson getJson() {
		return json;
	}


	public void setJson(PayResultResponseJson json) {
		this.json = json;
	}


	@Override
	public String toString() {
		return "OrderResult [ifaceVersion=" + ifaceVersion + ", next=" + next + ", ok=" + ok + ", responseTime="
				+ responseTime + ", safety=" + safety + ", responseJSON=" + responseJSON + ", json=" + json + "]";
	}
	
	public void func() {
		String str = "{        \"success\":true,        \"seq\":\"PAY20161125000008SHX\",        \"amount\":668,        \"paymentType\":\"rypay\",        \"paymentCode\":\"005\",        \"transactionNumber\":\"20GBQJVP81\",        \"transactionOrderNumber\":\"005GBQIYBY8\",        \"transactionSerialNumber\":\"005GBQ373I4\",        \"invokeMethod\":\"INOVKE\",        \"invokeParameters\":{            \"body\":\"20GBQJVP81\",            \"subject\":\"20GBQJVP81\",            \"sign_type\":\"RSA\",            \"notify_url\":\"https://pay.flycua.com/tyzf/aliPayNotify\",            \"out_trade_no\":\"82201611251748335644\",            \"url\":\"https://mapi.alipay.com/gateway.do\",            \"sign\":\"YZRymFEKb6v0RmPJR7Se%2FGSsFK…….%2F5T4n8o%3D\",            \"_input_charset\":\"UTF-8\",            \"it_b_pay\":\"15m\",            \"total_fee\":\"668.00\",            \"service\":\"mobile.securitypay.pay\",            \"seller_id\":\"2088101743372523\",            \"partner\":\"2088101743372523\",            \"payment_type\":\"1\"        }    }";
		PayResultResponseJson param = JSON.parseObject(str, PayResultResponseJson.class);
		System.out.println(param);
	}
	public class PayResultResponseJson {
			private Boolean success;					//是否成功，true/false
			private String seq;							//序列
			private String amount;						//总价
			private String paymentType;					//支付方式
			private String paymentCode;					//支付方式代号
			private String transactionNumber;			//订单号
			private String transactionOrderNumber;
			private String transactionSerialNumber;
			private String invokeMethod;				//默认invoke
			private InvokeParameters invokeParameters;	//支付宝支付链接参数


			public Boolean getSuccess() {
				return success;
			}


			public void setSuccess(Boolean success) {
				this.success = success;
			}


			public String getSeq() {
				return seq;
			}


			public void setSeq(String seq) {
				this.seq = seq;
			}


			public String getAmount() {
				return amount;
			}


			public void setAmount(String amount) {
				this.amount = amount;
			}


			public String getPaymentType() {
				return paymentType;
			}


			public void setPaymentType(String paymentType) {
				this.paymentType = paymentType;
			}


			public String getPaymentCode() {
				return paymentCode;
			}


			public void setPaymentCode(String paymentCode) {
				this.paymentCode = paymentCode;
			}


			public String getTransactionNumber() {
				return transactionNumber;
			}


			public void setTransactionNumber(String transactionNumber) {
				this.transactionNumber = transactionNumber;
			}


			public String getTransactionOrderNumber() {
				return transactionOrderNumber;
			}


			public void setTransactionOrderNumber(String transactionOrderNumber) {
				this.transactionOrderNumber = transactionOrderNumber;
			}


			public String getTransactionSerialNumber() {
				return transactionSerialNumber;
			}


			public void setTransactionSerialNumber(String transactionSerialNumber) {
				this.transactionSerialNumber = transactionSerialNumber;
			}


			public String getInvokeMethod() {
				return invokeMethod;
			}


			public void setInvokeMethod(String invokeMethod) {
				this.invokeMethod = invokeMethod;
			}


			public InvokeParameters getInvokeParameters() {
				return invokeParameters;
			}


			public void setInvokeParameters(InvokeParameters invokeParameters) {
				this.invokeParameters = invokeParameters;
			}


			@Override
			public String toString() {
				return "PayResultResponseJson [success=" + success + ", seq=" + seq + ", amount=" + amount + ", paymentType="
						+ paymentType + ", paymentCode=" + paymentCode + ", transactionNumber=" + transactionNumber
						+ ", transactionOrderNumber=" + transactionOrderNumber + ", transactionSerialNumber="
						+ transactionSerialNumber + ", invokeMethod=" + invokeMethod + ", invokeParameters=" + invokeParameters
						+ "]";
			}

		class InvokeParameters {
					private String partner;
					private String seller_id;
					private String out_trade_no;
					private String subject;
					private String body;
					private String total_fee;
					private String notify_url;
					private String service;
					private String payment_type;
					private String _input_charset;
					private String it_b_pay;
					private String sign;
					private String sign_type;
					private String url;
					
					public String getBody() {
						return body;
					}
					public void setBody(String body) {
						this.body = body;
					}
					public String getSubject() {
						return subject;
					}
					public void setSubject(String subject) {
						this.subject = subject;
					}
					public String getSign_type() {
						return sign_type;
					}
					public void setSign_type(String sign_type) {
						this.sign_type = sign_type;
					}
					public String getNotify_url() {
						return notify_url;
					}
					public void setNotify_url(String notify_url) {
						this.notify_url = notify_url;
					}
					public String getOut_trade_no() {
						return out_trade_no;
					}
					public void setOut_trade_no(String out_trade_no) {
						this.out_trade_no = out_trade_no;
					}
					public String getUrl() {
						return url;
					}
					public void setUrl(String url) {
						this.url = url;
					}
					public String getSign() {
						return sign;
					}
					public void setSign(String sign) {
						this.sign = sign;
					}
					@JSONField(name="_input_charset")
					public String get_input_charset() {
						return _input_charset;
					}
					@JSONField(name="_input_charset")
					public void set_input_charset(String _input_charset) {
						this._input_charset = _input_charset;
					}
					public String getIt_b_pay() {
						return it_b_pay;
					}
					public void setIt_b_pay(String it_b_pay) {
						this.it_b_pay = it_b_pay;
					}
					public String getTotal_fee() {
						return total_fee;
					}
					public void setTotal_fee(String total_fee) {
						this.total_fee = total_fee;
					}
					public String getService() {
						return service;
					}
					public void setService(String service) {
						this.service = service;
					}
					public String getSeller_id() {
						return seller_id;
					}
					public void setSeller_id(String seller_id) {
						this.seller_id = seller_id;
					}
					public String getPartner() {
						return partner;
					}
					public void setPartner(String partner) {
						this.partner = partner;
					}
					public String getPayment_type() {
						return payment_type;
					}
					public void setPayment_type(String payment_type) {
						this.payment_type = payment_type;
					}
					@Override
					public String toString() {
						return "InvokeParameters [body=" + body + ", subject=" + subject + ", sign_type=" + sign_type + ", notify_url="
								+ notify_url + ", out_trade_no=" + out_trade_no + ", url=" + url + ", sign=" + sign
								+ ", _input_charset=" + _input_charset + ", it_b_pay=" + it_b_pay + ", total_fee=" + total_fee
								+ ", service=" + service + ", seller_id=" + seller_id + ", partner=" + partner + ", payment_type="
								+ payment_type + "]";
					}
				}
		}
}

public class FastJson {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		PayResult result = new PayResult();
		result.func();
//		String str = "{\"ifaceVersion\": \"1.2\",\"next\": \"PM00001\",\"responseJSON\": \"c2yA6+w9X+XeZOOeLs6uPqluwC5Q0qKNoG7….Ff3UpK4qnNn8HQ==\",\"ok\": true,\"responseTime\": 1480067313269,\"safety\": true,\"json\":{\"success\": true,\"seq\": \"PAY20161125000008SHX\",\"amount\": 668,\"paymentType\": \"rypay\",\"paymentCode\": \"005\",\"transactionNumber\": \"20GBQJVP81\",\"transactionOrderNumber\": \"005GBQIYBY8\",\"transactionSerialNumber\": \"005GBQ373I4\",\"invokeMethod\": \"INOVKE\",\"invokeParameters\": {\"body\": \"20GBQJVP81\",\"subject\": \"20GBQJVP81\",\"sign_type\": \"RSA\",\"notify_url\": \"https://pay.flycua.com/tyzf/aliPayNotify\",\"out_trade_no\": \"82201611251748335644\",\"url\": \"https://mapi.alipay.com/gateway.do\",\"sign\": \"YZRymFEKb6v0RmPJR7Se%2FGSsFK…….%2F5T4n8o%3D\",\"_input_charset\": \"UTF-8\",\"it_b_pay\": \"15m\",\"total_fee\": \"668.00\",\"service\": \"mobile.securitypay.pay\",\"seller_id\": \"2088101743372523\",\"partner\": \"2088101743372523\",\"payment_type\": \"1\"}}}";
//		String str = "{        \"success\":true,        \"seq\":\"PAY20161125000008SHX\",        \"amount\":668,        \"paymentType\":\"rypay\",        \"paymentCode\":\"005\",        \"transactionNumber\":\"20GBQJVP81\",        \"transactionOrderNumber\":\"005GBQIYBY8\",        \"transactionSerialNumber\":\"005GBQ373I4\",        \"invokeMethod\":\"INOVKE\",        \"invokeParameters\":{            \"body\":\"20GBQJVP81\",            \"subject\":\"20GBQJVP81\",            \"sign_type\":\"RSA\",            \"notify_url\":\"https://pay.flycua.com/tyzf/aliPayNotify\",            \"out_trade_no\":\"82201611251748335644\",            \"url\":\"https://mapi.alipay.com/gateway.do\",            \"sign\":\"YZRymFEKb6v0RmPJR7Se%2FGSsFK…….%2F5T4n8o%3D\",            \"_input_charset\":\"UTF-8\",            \"it_b_pay\":\"15m\",            \"total_fee\":\"668.00\",            \"service\":\"mobile.securitypay.pay\",            \"seller_id\":\"2088101743372523\",            \"partner\":\"2088101743372523\",            \"payment_type\":\"1\"        }    }";
////		PayResult param = JSON.parseObject(str, PayResult.class);
//		PayResultResponseJson param = JSON.parseObject(str, PayResultResponseJson.class);
//		System.out.println(param);
/*
		Class<?> cls = param.getJson().getInvokeParameters().getClass();
		java.lang.reflect.Field[] fields = cls.getDeclaredFields();
		String result = "";
		
		if (fields != null) {
			for ( int i = 0; i < fields.length; i++ )
		    {  
				Field f = fields[i];  
		        f.setAccessible(true);  
		        if (f.getName().equals("url")) {
		        	continue;
		        }
		        result += f.getName() + "=\"" + f.get(param.getJson().getInvokeParameters()) + "\"&";
		    }  
			result = result.substring(0, result.length() - 1);
			System.out.println(result);
			String outTradeNo = StringUtils.substringBetween(result, "out_trade_no=\"", "\"&");
			String  totalFee = StringUtils.substringBetween(result, "total_fee=\"", "\"&");
			System.out.println(outTradeNo);
			System.out.println(totalFee);
		}
		*/
//		JSONObject jsonObj = JSON.parseObject(str);
//		for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
//	     	System.out.println(entry.getKey() + ":" + entry.getValue());
//	    }
	}
}
