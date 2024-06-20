package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URLが「〇〇〇.action」という形だったらサーブレットが実行される
// 例）/chapter23/Searc.action
//     /chapter23/Insert.action
@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet{
	
	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try{
			// リクエストされたページに応じた処理を実行する
			// リクエストされたURLの1文字目以降をとりだす
			// 例)url  =/chapter23/Search.action 
			// => path = chapter23/Search.action
			
			String path=request.getServletPath().substring(1);
			// pathの[.a]を[A]に置き換え、さらに[/]に[.]置き換える
			// 例）path = chapter23/Search.action
			// =>  name = chapter23.SearchAction
			String name=path.replace(".a", "A").replace('/', '/');
			
			// URLをもとにクラス名を取得したことになる
			
			// クラス名をもとにインスタンスを生成
			// Action action = new chapter23.SearchAction();と同じこと
			Action action=(Action)Class.forName(name).
				getDeclaredConstructor().newInstance();
			// excuteメソッド実行してフォワード先のJSPファイル名を取得
			String url=action.execute(request, response);
			
			// リクエストされたページに応じたJSPにフォワード
			request.getRequestDispatcher(url).
				forward(request, response);
		}catch(Exception e){
			// エラー処理
			e.printStackTrace(out);
		}
	}
	
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException {
		doPost(request, response);
	}

}
