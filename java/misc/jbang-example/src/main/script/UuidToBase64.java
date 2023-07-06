///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.Callable;

@Command(name = "UuidToBase64", mixinStandardHelpOptions = true, version = "UuidToBase64 0.1",
        description = "UuidToBase64 made with jbang")
class UuidToBase64 implements Callable<Integer> {

    @Parameters(index = "0", description = "The UUID to convert to an array of bytes in Base64URL", defaultValue = "World!")
    private String inputUuid;

    public static void main(String... args) {
        int exitCode = new CommandLine(new UuidToBase64()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        UUID uuid = UUID.fromString(inputUuid);
        byte[] bytes = UuidToBase64.uuidToBytes(uuid);
        System.out.println(UuidToBase64.bytesToBase64String(bytes));
        return 0;
    }

    private static byte[] uuidToBytes(final UUID uuid) {
        final ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }

    private static String bytesToBase64String(final byte[] bytes) {
        return Base64.getUrlEncoder().encodeToString(bytes);
    }
}
