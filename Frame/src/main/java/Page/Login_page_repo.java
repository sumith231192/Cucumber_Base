package Page;

import World.World;

public class Login_page_repo extends World
{
	
	World world = new World();
	
	public void StartApp(String browser, String url)
	{
		world.startApp(browser, url);
	}



}
