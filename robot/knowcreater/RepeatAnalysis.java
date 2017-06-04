package knowcreater;

public class RepeatAnalysis
{
	private String before = "";
	private int count = 0;

	public boolean isReapeat(String now)
	{
		String matchString = Tool.dynamicProgram(now, before);
		float nowLength = now.length(), beforeLength = before.length(), matchStringLength;
		if (before.trim().length() == 0)
		{
			before = now;
			return false;
		}
		if (matchString == null)
		{
			count = 0;
			before = now;
			return false;
		}
		matchStringLength = matchString.length();
		beforeLength = beforeLength > nowLength ? beforeLength : nowLength;
		if (matchString.length() / beforeLength > 0.78)
		{
			count++;
			before = now;
			return true;
		}
		count = 0;
		before = now;
		return false;
	}

	public int getCount()
	{
		return count;
	}
}
