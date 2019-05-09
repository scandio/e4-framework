package de.scandio.e4;

import de.scandio.e4.client.E4Client;
import org.apache.commons.cli.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.util.HashMap;

@SpringBootApplication
public class E4Application {

	public static void main(String[] args) {
		final CommandLine parsedArgs = parseArgs(args);

		try {
			if (parsedArgs.hasOption("worker-only")) {
				startWorkerOnly(parsedArgs);
			} else {
				startClient(parsedArgs);
			}
		} catch (Exception ex) {
			System.out.println("Encountered unenjoyable exception:");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public static void startClient(CommandLine parsedArgs) throws Exception {
		System.out.println("Starting E4 Client... Enjoy!");
		final E4Client e4Client = new E4Client(parsedArgs);
		e4Client.start();
	}

	public static void startWorkerOnly(CommandLine parsedArgs) {
		String port = parsedArgs.getOptionValue("port");

		// we could also check if the port is actually a valid port
		if (port == null) {
			port = "4444";
		}

		System.out.println("Starting E4 in worker-only mode... Enjoy!");

		final HashMap<String, Object> props = new HashMap<>();
		props.put("server.port", port);
		new SpringApplicationBuilder()
				.sources(E4Application.class)
				.properties(props)
				.run();

		System.out.println("E4 Worker is running on: http://localhost:"+port+"/");
	}

	/**
	 * Parses the arguments and returns them or shuts down the application if an error occours.
	 * @param args The program args.
	 */
	private static CommandLine parseArgs(String[] args) {
		final Options options = new Options();

		final Option configOption = new Option("c", "config", true, "Path to a config JSON file. Required if you're not starting in worker-only mode.");
		configOption.setRequired(false);
		options.addOption(configOption);

		final Option workerOnlyOption = new Option("w", "worker-only", false, "Run this E4 instance in worker-only-mode and listen for commands from an E4 client.");
		workerOnlyOption.setRequired(false);
		options.addOption(workerOnlyOption);

		final Option portOption = new Option("p", "port", true, "Port to run the E4 Worker on. Required for worker-only mode.");
		portOption.setRequired(false);
		options.addOption(portOption);


		final CommandLineParser parser = new DefaultParser();

		try {
			return parser.parse(options, args);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			new HelpFormatter().printHelp("utility-name", options);
			System.exit(1);
		}

		return null;
	}
}
