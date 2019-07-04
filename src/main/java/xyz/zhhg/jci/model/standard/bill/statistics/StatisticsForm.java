package xyz.zhhg.jci.model.standard.bill.statistics;
/**
 * select a.money, a.d time <if test="useDetype">, b.name typename</if>
	  from (select sum(a.money) money
 			<trim prefixOverrides=",">
	         	<if test="useDate">,to_char(a.spawndate, #{dateMode}) d</if>
	         	<if test="useDetype">,a.detype</if>
	         </trim>
	          from jci.tb_bill_detail a
	        
	         where spawndate between to_date(#{begindate}, 'yyyy-mm-dd') and
	               to_date(#{enddate}, 'yyyy-mm-dd')
	           and openid = #{openid}
	           and exists
	         (select 1
	                  from jci.tb_account_detype b, jci.tb_account_type c
	                 where b.id = a.detype
	                   and b.typeid = c.id
	                   and c.type = #{rdtype})
	          <trim prefix="group by" suffixOverrides=",">
	         	<if test="useDate">to_char(a.spawndate, #{dateMode}) ,</if>
	         	<if test="useDetype">a.detype,</if>
	         </trim>
	       
	  <if test="!onlyDate">
	  left join (select a.name || '-' || b.name name, b.id detype
	               from jci.tb_account_type a, jci.tb_account_detype b
	              where a.id = b.typeid) b
	    on a.detype = b.detype
	  </if>
 */
public class StatisticsForm {
	private boolean useDetype;
	private boolean useDate;
	private String dateMode;
	
	private String begindate;
	private String enddate;
	private String openid;
	
	private int rdtype;

	public boolean isUseDetype() {
		return useDetype;
	}

	public void setUseDetype(boolean useDetype) {
		this.useDetype = useDetype;
	}

	public boolean isUseDate() {
		return useDate;
	}

	public void setUseDate(boolean useDate) {
		this.useDate = useDate;
	}

	public String getDateMode() {
		return dateMode;
	}

	public void setDateMode(String dateMode) {
		this.dateMode = dateMode;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getRdtype() {
		return rdtype;
	}

	public void setRdtype(int rdtype) {
		this.rdtype = rdtype;
	}
	
	
	
	
	
	
	
}
