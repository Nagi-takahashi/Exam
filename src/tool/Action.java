package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	/**
	 * ページに応じた処理を実行し、フォワード先のJSPファイル名を返却する
	 * @param request
	 * @param response
	 * @return フォワード先のJSPファイル名
	 * @throws Exception
	 */
	public abstract String execute(
		HttpServletRequest request, HttpServletResponse response
	)throws Exception;
	
}
