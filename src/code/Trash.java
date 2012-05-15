/*
	private static void checkArguments(String[] args){
		int var;
		
		String usage= "Error: Incorrect arguments/values.\n" +
				"Usage:\n" +
				"-w X - define custom window width (where 470<=X<=1600; default: 760)\n" +
				"-h X - define custom window height (where 400<=X<=900; default: 500)\n" +
				"-r X - define custom layout ratio (only appliable to layout #2; where 0<=X<=100; default: 100)\n" +
				"-f X - define custom font size (where 10<=X<=25; default: 13)\n\n" +
				"Example: btg.jar -w 900 -h 700 -f 16";
		
		for(int i=0; i < args.length; i++){	
			try{
				switch(args[i]){
				case "-w": {
					var=Integer.parseInt(args[++i]);
					if(var>=470 && var<=1600){
						wWidth=var;
					}else{
						System.out.println(usage);
					}
					break;
					}
				case "-h": {
					var=Integer.parseInt(args[++i]);
					if(var>=400 && var<=900){
						wHeight=var;
					}else{
						System.out.println(usage);
					}
					break;
					}
				case "-r": {
					var=Integer.parseInt(args[++i]);
					if(var>=0 && var<=100){
						posTreeRatio=(double) (var/100);
					}else{
						System.out.println(usage);
					}
					break;
					}
				case "-f": {
					var=Integer.parseInt(args[++i]);
					if(var>=10 && var<=25){
						fontSize=var;
						textFont= new Font("Arial",Font.PLAIN,fontSize);
					}else{
						System.out.println(usage);
					}
					break;
					}
				}
			} catch( Exception e) {
				System.out.println(usage);
				System.exit(1);
			}
		}
	}  */
